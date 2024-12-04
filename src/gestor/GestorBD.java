
package gestor;

import excepciones.MyException;
import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.Empleado;
import modelo.Lote;
import modelo.Maquina;

/**
 *
 * @author Marcos
 */
public class GestorBD {

    private String user;
    private String db;
    private String conexion;
    private String password;
    private static Connection conn;
  //  private static ArrayList<Almacen> listadoEntrantes = new ArrayList<>();
  //  private static ArrayList<Almacen> listadoSinStock = new ArrayList<>();
    private static File carpeta = new File("ficheros");
    
    public GestorBD(String user, String db, String conexion, String password) {
        //inicializamos todos los parámetros, pero no nos conectamos a la base
        this.user = user;
        this.db = db;
        this.conexion = conexion;
        this.password = password;
        this.conn = null;
    }
    
    public boolean iniciarConexion() throws MyException {
        try {
            //cargar el driver
            Class.forName("com.mysql.jdbc.Driver");
            this.conn = DriverManager.getConnection(conexion + db, user, password);
            return true;
        } catch (ClassNotFoundException ex) {
            //ex.printStackTrace();
            throw new MyException("No has puesto la librería MySql");
        } catch (SQLException ex) {
            ex.printStackTrace();
            throw new MyException(ex.getSQLState() + " Error al conectarse");
        }
    }

    public void cerrarConexion() throws MyException {
        try {
            this.conn.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
            throw new MyException(ex.getSQLState() + " no se ha podido cerrar la base de datos, posible perdida de informacion");
        }
    }
    
    public static Empleado existeEmpleado(String codEmp) throws MyException{
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        try{
            ps = conn.prepareStatement("SELECT * FROM empleados WHERE COD_EMP = ?");
            ps.setString(1, codEmp);
            rs = ps.executeQuery();
            if(!rs.next()){
                return null;
            }
            else{
                return new Empleado(rs.getInt("cod_emp"),rs.getString("nombre_emp"),
                                    rs.getString("dni_emp"),rs.getInt("tlf_emp"));
            }
        }
        catch (SQLException ex) {
           throw new MyException("Error consultando el codigo de empleado" + codEmp);
        }
        catch (NumberFormatException ex){
            throw new MyException("Los codigos de empleados son numéricos.");
        }
        
    }
    
    // Comprueba si el parámetro "contra" es igual a la contraseña registrada en BD del empleado 
    // con codigo "codEmp"
    public static boolean compruebaContrasena(String contra,String codEmp) throws MyException{
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        try{
            ps = conn.prepareStatement("SELECT CONTRASENA_EMP FROM empleados WHERE COD_EMP = ?");
            ps.setString(1, codEmp);
            rs = ps.executeQuery();
            rs.next();
            if(!rs.getString("contrasena_emp").equals(contra)){
                return false;
            }
            return true;
        }
        catch (SQLException ex) {
           throw new MyException("Error consultando la contraseña del empleado " + codEmp +'\n'+ ex.getMessage());
        }
    }
    
    public static Lote existeLote(String codLote) throws MyException{
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        try{
            ps = conn.prepareStatement("SELECT * FROM lotes WHERE COD_LOTE = ?");
            ps.setString(1, codLote);
            rs = ps.executeQuery();
            if(!rs.next()){
                return null;
            }
            else{
                return new Lote(rs.getInt("cod_lote"),rs.getInt("tipo"),
                                    rs.getInt("cantidad"),rs.getBoolean("imperf_lote"));
            }
            
        }
        catch (SQLException ex) {
           throw new MyException("Error consultando el codigo de lote" + codLote + "\n" + ex.getMessage());
        }
    }
    public static Maquina existeMaquina(String codMaq) throws MyException{
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        try{
            ps = conn.prepareStatement("SELECT * FROM maquinas WHERE COD_MAQ = ?");
            ps.setString(1, codMaq);
            rs = ps.executeQuery();
            if(!rs.next()){
                return null;
            }
            else{
                return new Maquina(rs.getShort("cod_maq"),rs.getString("nombre_maq"),rs.getShort("num_operarios"));
            }
        }
        catch (SQLException ex) {
           throw new MyException("Error consultando el codigo " + codMaq);
        }
    }
    public static String fecha(){
        Calendar fecha = new GregorianCalendar();
        
        String anyo = Integer.toString(fecha.get(Calendar.YEAR));
        String mes = Integer.toString(fecha.get(Calendar.MONTH) + 1);
        String dia = Integer.toString(fecha.get(Calendar.DAY_OF_MONTH));
        return dia + "-" + mes + "-" + anyo;
    }
    
    public static String horaActual(){
        Calendar horaAct = new GregorianCalendar();
        
        String horas = Integer.toString(horaAct.get(Calendar.HOUR_OF_DAY));
        String minutos = Integer.toString(horaAct.get(Calendar.MINUTE));
        
        return horas + ":" + minutos;
    }
    
    public static void registrarFichaje(){
        
    }
    
    public static String numErrores() throws MyException{
        int totalErrores = 0;
        try {
            PreparedStatement ps = conn.prepareStatement("SELECT COUNT(*) FROM errores;");
            ResultSet rs = ps.executeQuery();
            
            if(rs.next()){
                totalErrores = rs.getInt(1);
            }
            else{
                throw new MyException("Error accediendo a la tabla errores.");
            }
        } catch (SQLException ex) {
            throw new MyException("Error obteniendo el codigo de error");
        }
        return String.valueOf(totalErrores);
    }
    
    public static boolean registrarError(String codErr, String desc, int cantidad, String hora) throws MyException{
        try {
            PreparedStatement ps = conn.prepareStatement("INSERT INTO ERRORES VALUES (?,?,?,?);");
            ps.setString(1, codErr);
            ps.setString(2, desc);
            ps.setInt(3,cantidad);
            ps.setString(4,hora);
            
            if(ps.executeUpdate()== 1){
                return true;
            }
            return false;
        } catch (SQLException ex) {
            throw new MyException("Error al registrar el error.");
        }
    }
    
    public static void registrarFichaje(int codEmple, int codLote, int codMaq, String horaIni, int cantidad) throws MyException{
        try{
            PreparedStatement ps = conn.prepareStatement("INSERT INTO PRODUCCION VALUES(?,?,?,?,?,?,?)");
        } catch (SQLException ex) {
            throw new MyException("Error al registrar el fichaje");
        }
    }
}

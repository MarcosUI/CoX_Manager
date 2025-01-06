
package gestor;

import com.mysql.jdbc.exceptions.jdbc4.CommunicationsException;
import excepciones.MyException;
import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashSet;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import modelo.Empleado;
import modelo.Lote;
import modelo.LoteActivo;
import modelo.LoteTerminado;
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

    public static Connection getConexion() {
        return conn;
    }
    
    public boolean iniciarConexion() throws MyException {
        try {
            //cargar el driver
            Class.forName("com.mysql.jdbc.Driver");
            this.conn = DriverManager.getConnection(conexion + db, user, password);
            return true;
        } 
        catch (CommunicationsException ex){
            throw new MyException("No ha sido posible conectarse a la base de datos.");
        } 
        catch (ClassNotFoundException ex) {
            throw new MyException("No has puesto la librería MySql");
        } 
        catch (SQLException ex) {
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
                                    rs.getInt("cantidad"),rs.getBoolean("imperf_lote"),rs.getBoolean("lote_activo"));
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
        if(dia.length()<2){
            dia = "0" + dia;
        }
        return dia + "/" + mes + "/" + anyo;
    }
    
    public static String fechaGuiones(){
        Calendar fecha = new GregorianCalendar();
        String anyo = Integer.toString(fecha.get(Calendar.YEAR));
        String mes = Integer.toString(fecha.get(Calendar.MONTH) + 1);
        String dia = Integer.toString(fecha.get(Calendar.DAY_OF_MONTH));
        if(dia.length()<2){
            dia = "0" + dia;
        }
        return dia + "-" + mes + "-" + anyo;
    }
    
    public static java.sql.Date fechaSQL() throws MyException{
        DateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        try {
            Date fecha = formato.parse(GestorBD.fecha());
            return new java.sql.Date(fecha.getTime());
            
        } catch (ParseException ex) {
           throw new MyException("Error creando fecha para SQL.\n"+ex.getMessage());
        }
    }
    
    public static java.sql.Date formatoFechaSQL(String fecha) throws MyException{
        DateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        try {
            Date fechaAux = formato.parse(fecha);
            return new java.sql.Date(fechaAux.getTime());
            
        } catch (ParseException ex) {
           throw new MyException("Error creando fecha para SQL.\n"+ex.getMessage());
        }
    }
    
    public static String horaActual(){
        Calendar horaAct = new GregorianCalendar();
        
        String horas = Integer.toString(horaAct.get(Calendar.HOUR_OF_DAY));
        String minutos = Integer.toString(horaAct.get(Calendar.MINUTE));
        
        return horas + ":" + minutos;
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
            throw new MyException("Error contando los registros de la tabla \"ERRORES\"");
        }
        return String.valueOf(totalErrores);
    }
    
    public static Integer[] consultaEstadoLote(int codL) throws MyException{
        Integer[] datos = new Integer[2];
        try{
            
            PreparedStatement ps = conn.prepareStatement("SELECT MAX(COD_MAQ), SUM(CANTIDAD) FROM PRODUCCION WHERE COD_LOTE = ?");
            ps.setInt(1,codL);
            ResultSet rs = ps.executeQuery();
            
            if(rs.next()){
                datos[0] = rs.getInt(1);
                datos[1] = rs.getInt(2);
                return datos;
            }
            else{
                throw new MyException("El lote aún no ha empezado el proceso de producción.");
            }
        } catch (SQLException ex) {
            throw new MyException("Error accediendo a la tabla errores.");
        }
    }
    
    public static void consultaErroresLote(int codL,HashSet<String> errores) throws MyException{
        Integer[] datos = new Integer[2];
        try{
            
            PreparedStatement ps = conn.prepareStatement("SELECT ERROR FROM PRODUCCION WHERE COD_LOTE = ?");
            ps.setInt(1,codL);
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
                String codError = rs.getString("ERROR");
                if(codError != null){
                    errores.add(codError);
                }
            }
        } catch (SQLException ex) {
            throw new MyException("Error accediendo a la tabla errores.");
        }
    }
    
    public static boolean registrarError(String codErr, String desc, int cantidad, String hora) throws MyException{
        try {
            PreparedStatement ps = conn.prepareStatement("INSERT INTO errores VALUES (?,?,?,?);");
            ps.setString(1, codErr);
            ps.setString(2, desc);
            ps.setInt(3,cantidad);
            ps.setString(4,hora);
            
            if(ps.executeUpdate()== 1){
                return true;
            }
            return false;
        } catch (SQLException ex) {
            throw new MyException("Error al registrar el error.\n" + ex.getMessage());
        }
    }
  
     public static void registrarFichajeSinError(int codEmple, int codLote, int codMaquina, 
            String horaIni) throws MyException {

        PreparedStatement ps;

        // Mirar el formato que tiene la hora que devuelve la función, el separador en SQL para el dato TIME es ':'
        String horaFin = GestorBD.horaActual();
        try {
            ps = conn.prepareStatement("INSERT INTO PRODUCCION(COD_EMP,COD_MAQ,COD_LOTE,DIA,HORA_INICIO,HORA_FIN,CANTIDAD)"
                    + " VALUES (?,?,?,?,?,?,?);");
            ps.setInt(1, codEmple);
            ps.setInt(2, codMaquina);
            ps.setInt(3, codLote);
            ps.setDate(4, GestorBD.fechaSQL());
            ps.setString(5, horaIni);
            ps.setString(6, horaFin);
            ps.setInt(7, 50);

            ps.executeUpdate();
            
        } 
        catch (SQLException ex) {
            throw new MyException("Error registrando el fichaje.\n"+ex.getMessage());
        }
    }

    public static void registrarFichajeConError(int codEmple, int codLote, int codMaquina, 
            String horaIni, String codError) throws MyException {

        PreparedStatement ps;

        // Mirar el formato que tiene la hora que devuelve la función, el separador en SQL para el dato TIME es ':'
        String horaFin = GestorBD.horaActual();
        try {
            ps = conn.prepareStatement("INSERT INTO PRODUCCION(COD_EMP,COD_MAQ,COD_LOTE,DIA,ERROR,HORA_INICIO,HORA_FIN,CANTIDAD)"
                    + " VALUES (?,?,?,?,?,?,?,?);");

            ps.setInt(1, codEmple);
            ps.setInt(2, codMaquina);
            ps.setInt(3, codLote);
            ps.setDate(4, GestorBD.fechaSQL());
            ps.setString(5, codError);
            ps.setString(6, horaIni);
            ps.setString(7, horaFin);
            ps.setInt(8, 50);

            ps.executeUpdate();
            
        } 
        catch (SQLException ex) {
            throw new MyException("Error registrando el fichaje.\n"+ex.getMessage());
        }
    }
    
    public static void registroFichajeGestor(int codGestor, String horaInicial) throws MyException{
        PreparedStatement ps;
        String horaFinal = GestorBD.horaActual();
        try{
            ps = conn.prepareStatement("INSERT INTO FICHAJE_GESTORES(COD_EMP, DIA_FICHAJE, HORA_INICIO, HORA_FIN) "
                    + "VALUES (?,?,?,?)");
            ps.setInt(1, codGestor);
            ps.setDate(2,GestorBD.fechaSQL());
            ps.setString(3, horaInicial);
            ps.setString(4, horaFinal);
            
            ps.executeUpdate();
        } 
        catch (SQLException ex) {
            throw new MyException("Error registrando el fichaje del gestor " + codGestor + "\n" + ex.getMessage());
        }
    }
    
    public static void altaLote(int codLote,int tipo, int cantidad, boolean imperf) throws MyException{
        PreparedStatement ps;
        if (GestorBD.existeLote(String.valueOf(codLote)) != null) {
            throw new MyException("El lote con codigo " +codLote +" ya existe.");
        } 
        else {
            try {
                ps = conn.prepareStatement("INSERT INTO LOTES VALUES (?,?,?,?,?)");
                ps.setInt(1, codLote);
                ps.setInt(2, tipo);
                ps.setInt(3, cantidad);
                ps.setBoolean(4, imperf);
                ps.setBoolean(5, true);

                ps.executeUpdate();
            } catch (SQLException ex) {
                throw new MyException("Error registrando el nuevo lote.");
            }
        }
    }
    
    public static ArrayList<modelo.Error> consultaListaErrores(String fechaIni, String fechaFin) throws MyException{
        ArrayList<modelo.Error> listaErrores = new ArrayList<>();
        PreparedStatement ps;
        ResultSet rs;
        String fechaIniFormato = formatoFechaSQL(fechaIni).toString();
        String fechaFinFormato = formatoFechaSQL(fechaFin).toString();
        
        String consulta = "SELECT e.*, p.DIA FROM ERRORES e JOIN PRODUCCION p ON e.COD_ERROR = p.ERROR "
                + "WHERE p.DIA >= ? AND p.dia <= ?;";
        try{
            ps = conn.prepareStatement(consulta);
            ps.setString(1,fechaIniFormato);
            ps.setString(2,fechaFinFormato);
            rs = ps.executeQuery();
            
            while(rs.next()){
                String cod = rs.getString("COD_ERROR");
                int cant = rs.getInt("QTY_AFECTADO");
                String descripcion = rs.getString("DESCRIPCION");
                java.sql.Time horaSQL = rs.getTime("HORA_ERROR");
                String hora = horaSQL.toString();
                java.sql.Date diaSQL = rs.getDate("DIA");
                String dia = diaSQL.toString();
                
                modelo.Error e = new modelo.Error(cod, cant, descripcion, dia, hora);
                listaErrores.add(e);
            }
            
        } catch (SQLException ex) {
            throw new MyException("Error al realizar la consulta\nde los errores en base de datos\n" + ex.getMessage());
        }
        return listaErrores;
    }
    
    private static int codigoEmpleadoNuevo(int tipoEmpleado) throws MyException{
        PreparedStatement ps;
        ResultSet rs;
        try {
            
            ps = conn.prepareStatement("SELECT MAX(COD_EMP) FROM empleados WHERE COD_EMP LIKE ?");
            ps.setString(1,tipoEmpleado + "%");
            rs = ps.executeQuery();
            if(rs.next()){
                
                return (rs.getInt(1) + 1) ;
            }
            return -1;
        } catch (SQLException ex) {
            throw new MyException("Error obteniendo el nuevo codigo de empleado.\n" + ex.getMessage());
        }
    }
    
    public static int altaEmpleado(int tipoEmpleado,String dni, String nombre, String tlf, String contra) throws MyException{
        PreparedStatement ps;
        ResultSet rs;
        int codEmp = codigoEmpleadoNuevo(tipoEmpleado);
        
        if(codEmp == -1){
            return codEmp;
        }
        
        try {
            if(tipoEmpleado != 3){
                ps = conn.prepareStatement("INSERT INTO EMPLEADOS(COD_EMP,DNI_EMP,NOMBRE_EMP,TLF_EMP) VALUES (?,?,?,?)");
                ps.setInt(1,codEmp);
                ps.setString(2, dni);
                ps.setString(3, nombre);
                ps.setString(4, tlf);
                
                if(ps.executeUpdate() == 0){
                    throw new MyException("Se han insertado 0 filas en la tabla EMPLEADOS");
                }
                return codEmp;
            }
            else{
                ps = conn.prepareStatement("INSERT INTO EMPLEADOS(COD_EMP,DNI_EMP,NOMBRE_EMP,TLF_EMP,CONTRASENA_EMP) "
                        + "VALUES (?,?,?,?,?)");
                ps.setInt(1,codEmp);
                ps.setString(2, dni);
                ps.setString(3, nombre);
                ps.setString(4, tlf);
                ps.setString(5, contra);
                
                if(ps.executeUpdate() == 0){
                    throw new MyException("Se han insertado 0 filas en la tabla EMPLEADOS");
                }
                return codEmp;
            }
            
        } catch (SQLException ex) {
            throw new MyException("Error registrando al nuevo empleado.\n" + ex.getMessage());
        }
    }
    
    public static void consultaLotesTerminados(Connection conn ,List<LoteTerminado> listaLotes) throws MyException{
        
        PreparedStatement ps;
        ResultSet rs;
        
        String consulta = "SELECT l.COD_LOTE, l.TIPO, l.CANTIDAD AS CANTIDAD_LOTE, l.IMPERF_LOTE, "
                + "SUM(p.CANTIDAD) AS CANTIDAD_PRODUCCION "
                + "FROM LOTES l "
                + "LEFT JOIN PRODUCCION p ON l.COD_LOTE = p.COD_LOTE "
                + "WHERE l.LOTE_ACTIVO = FALSE GROUP BY l.COD_LOTE;";
        try{
            ps = conn.prepareStatement(consulta);
            
            rs = ps.executeQuery();
            
            while(rs.next()){
                int codLote = rs.getInt("COD_LOTE");
                int tipo = rs.getInt("TIPO");
                int cantLote = rs.getInt("CANTIDAD_LOTE");
                boolean imperf = rs.getBoolean("IMPERF_LOTE");
                int cantProd = rs.getInt("CANTIDAD_PRODUCCION");
                
                LoteTerminado lot = new LoteTerminado(codLote,tipo,cantLote,cantProd,imperf);
                listaLotes.add(lot);
            }
            
        } catch (SQLException ex) {
            throw new MyException("Error al realizar la consulta\nde los errores en base de datos\n" + ex.getMessage());
        }
    }
    
     public static void consultaLotesActivos(Connection conn ,List<LoteActivo> listaLotes) throws MyException{
        
        PreparedStatement ps;
        ResultSet rs;
        
        String consulta = "SELECT l.COD_LOTE, l.TIPO, l.CANTIDAD AS CANTIDAD_LOTE, l.IMPERF_LOTE, "
                + "SUM(p.CANTIDAD) AS CANTIDAD_PRODUCCION,MAX(p.COD_MAQ) AS MAYOR_COD_MAQ "
                + "FROM LOTES l "
                + "LEFT JOIN PRODUCCION p ON l.COD_LOTE = p.COD_LOTE "
                + "WHERE l.LOTE_ACTIVO = TRUE GROUP BY l.COD_LOTE;";
        try{
            ps = conn.prepareStatement(consulta);
            
            rs = ps.executeQuery();
            
            while(rs.next()){
                int codLote = rs.getInt("COD_LOTE");
                int tipo = rs.getInt("TIPO");
                int cantLote = rs.getInt("CANTIDAD_LOTE");
                boolean imperf = rs.getBoolean("IMPERF_LOTE");
                int cantProd = rs.getInt("CANTIDAD_PRODUCCION");
                int codMaq = rs.getInt("MAYOR_COD_MAQ");
                
                LoteActivo lote = new LoteActivo(codLote,tipo,cantLote,cantProd,codMaq,imperf);
                listaLotes.add(lote);
            }
            
        } catch (SQLException ex) {
            throw new MyException("Error al realizar la consulta\nde los errores en base de datos\n" + ex.getMessage());
        }
    }
     
     public static int consultaUltimaMaquina(Connection conn, int codLote) throws MyException {
        PreparedStatement ps;
        ResultSet rs;

        String consulta = "SELECT MAX(COD_MAQ) FROM PRODUCCION WHERE COD_LOTE = ?";
        try {
            ps = conn.prepareStatement(consulta);
            ps.setInt(1, codLote);
            rs = ps.executeQuery();
            rs.next();
            return rs.getInt(1);

        } catch (SQLException ex) {
            throw new MyException("Error al realizar la consulta\nde los errores en base de datos\n" + ex.getMessage());
        }
    }
     
    public static void consultaLotesDiarios(ArrayList<String> lineasFichero) throws MyException{
        PreparedStatement ps;
        ResultSet rs;
        ArrayList<String> lineasTexto = new ArrayList<>();

        String consulta = "SELECT COD_LOTE,MAX(COD_MAQ) FROM PRODUCCION WHERE DIA = ? GROUP BY COD_LOTE";
        try {
            ps = conn.prepareStatement(consulta);
            ps.setDate(1,GestorBD.fechaSQL());
            rs = ps.executeQuery();
            
            while(rs.next()){
                int codLote = rs.getInt(1);
                int codMaq = rs.getInt(2);
                String errores = consultaErroresDiarios(codLote);
                
                
                String linea = "Lote: " + String.valueOf(codLote)+ ", "
                        + "Ultima máquina: " + String.valueOf(codMaq)+", " 
                        + "Errores: " + errores;
                
                lineasFichero.add(linea);
            }
            
        } catch (SQLException ex) {
            throw new MyException("Error al realizar la consulta\nde los errores en base de datos\n" + ex.getMessage());
        }
    }
    
    private static String consultaErroresDiarios(int codLote) throws MyException{
        PreparedStatement ps;
        ResultSet rs;
        ArrayList<String> lineasTexto = new ArrayList<>();

        String consulta = "SELECT ERROR FROM produccion WHERE DIA = ? && COD_LOTE = ? GROUP BY ERROR;";
        try {
            ps = conn.prepareStatement(consulta);
            ps.setDate(1,GestorBD.fechaSQL());
            ps.setInt(2,codLote);
            rs = ps.executeQuery();
            String codErrores = "";
            while (rs.next()) {
                
                if(rs.getString(1) != null){
                    codErrores += rs.getString(1) + ", ";
                }
            }
            return codErrores;
            
        } catch (SQLException ex) {
            throw new MyException("Error al realizar la consulta\nde los errores en base de datos\n" + ex.getMessage());
        }
    }
}

package modelo;

/**
 *
 * @author Marcos
 */
public class Empleado {
    
    private int codEmpleado;
    private String nomEmpleado;
    private int tlfEmpleado;
    private String dniEmpleado;
    
    public Empleado ( int codEmp, String nomEmp, String dniEmp, int tlfEmp){
        this.codEmpleado = codEmp;
        this.nomEmpleado = nomEmp;
        this.dniEmpleado = dniEmp;
        this.tlfEmpleado = tlfEmp;
    }
    public int getCodEmpleado(){
        return this.codEmpleado;
    }

    public String getNombre() {
        return this.nomEmpleado;
    }
}

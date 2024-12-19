package modelo;

import java.lang.reflect.Array;

/**
 *
 * @author Marcos
 */
public class Error {
    private String codError;
    private int cantidadAfectada;
    private String descripcion;
    private String dia;
    private String hora;

    public Error(String codError, int cantidadAfectada, String descripcion, String dia, String hora) {
        this.codError = codError;
        this.cantidadAfectada = cantidadAfectada;
        this.descripcion = descripcion;
        this.dia = dia;
        this.hora = hora;
    }
    
    public String getCodError() {
        return codError;
    }

    public void setCodError(String codError) {
        this.codError = codError;
    }

    public int getCantidadAfectada() {
        return cantidadAfectada;
    }

    public void setCantidadAfectada(int cantidadAfectada) {
        this.cantidadAfectada = cantidadAfectada;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getDia() {
        return dia;
    }

    public String getHora() {
        return hora;
    }

    @Override
    public String toString() {
        return "Error{" + "codError=" + codError + ", cantidadAfectada=" + cantidadAfectada + ", descripcion=" + descripcion + ", dia=" + dia + ", hora=" + hora + '}';
    }
    
    public Object[] toArray(){
        Object[] arrayAux = new Object[5];
        arrayAux[0] = this.codError;
        arrayAux[1] = this.dia;
        arrayAux[2] = this.hora;
        arrayAux[3] = this.cantidadAfectada;
        arrayAux[4] = this.descripcion;
        
        return arrayAux;
    }
}

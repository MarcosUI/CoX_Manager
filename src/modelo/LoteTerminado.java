/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author Marcos
 */
public class LoteTerminado {
    private int codLoteTerminado;
    private int tipoLoteTerminado;
    private int cantidadLoteTerminado;
    private int cantProcesadaTerminado;
    private boolean imperfeccionTerminado;

    public LoteTerminado(int codLoteTerminado, int tipoLoteTerminado, int cantLoteTerminado, int cantProducidaLoteTerminado, boolean imperfLoteTerminado) {
        this.codLoteTerminado = codLoteTerminado;
        this.tipoLoteTerminado = tipoLoteTerminado;
        this.cantidadLoteTerminado = cantLoteTerminado;
        this.cantProcesadaTerminado = cantProducidaLoteTerminado;
        this.imperfeccionTerminado = imperfLoteTerminado;
    }

    public int getCodLoteTerminado() {
        return codLoteTerminado;
    }

    public void setCodLoteTerminado(int codLoteTerminado) {
        this.codLoteTerminado = codLoteTerminado;
    }

    public int getTipoLoteTerminado() {
        return tipoLoteTerminado;
    }

    public void setTipoLoteTerminado(int tipoLoteTerminado) {
        this.tipoLoteTerminado = tipoLoteTerminado;
    }

    public int getCantidadLoteTerminado() {
        return cantidadLoteTerminado;
    }

    public void setCantidadLoteTerminado(int cantidadLoteTerminado) {
        this.cantidadLoteTerminado = cantidadLoteTerminado;
    }

    public int getCantProcesadaTerminado() {
        return cantProcesadaTerminado;
    }

    public void setCantProcesadaTerminado(int cantProcesadaTerminado) {
        this.cantProcesadaTerminado = cantProcesadaTerminado;
    }

    public boolean isImperfeccionTerminado() {
        return imperfeccionTerminado;
    }

    public void setImperfeccionTerminado(boolean imperfeccionTerminado) {
        this.imperfeccionTerminado = imperfeccionTerminado;
    }

    @Override
    public String toString() {
        return "LoteTerminado{" + "codLoteTerminado=" + codLoteTerminado + ", tipoLoteTerminado=" + tipoLoteTerminado + ", cantLoteTerminado=" + cantidadLoteTerminado + ", cantProducidaLoteTerminado=" + cantProcesadaTerminado + ", imperfLoteTerminado=" + imperfeccionTerminado + '}';
    }
   
    
}

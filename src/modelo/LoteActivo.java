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
public class LoteActivo {
    private int codLote;
    private int tipoLote;
    private int cantLote;
    private int cantProducidaLote;
    private int ultimaMaquina;
    private boolean imperfLote;

    public LoteActivo(int codLote, int tipoLote, int cantLote, int cantProdLote,int codMaq, boolean imperfLote) {
        this.codLote = codLote;
        this.tipoLote = tipoLote;
        this.cantLote = cantLote;
        this.cantProducidaLote = cantProdLote;
        this.imperfLote = imperfLote;
    }

    public int getCantProducidaLote() {
        return cantProducidaLote;
    }

    public void setCantProducidaLote(int cantProducidaLote) {
        this.cantProducidaLote = cantProducidaLote;
    }

    public int getUltimaMaquina() {
        return ultimaMaquina;
    }

    public void setUltimaMaquina(int ultimaMaquina) {
        this.ultimaMaquina = ultimaMaquina;
    }

    
    
    public int getCodLote() {
        return codLote;
    }

    public void setCodLote(int codLote) {
        this.codLote = codLote;
    }

    public int getTipoLote() {
        return tipoLote;
    }

    public void setTipoLote(int tipoLote) {
        this.tipoLote = tipoLote;
    }

    public int getCantLote() {
        return cantLote;
    }

    public void setCantLote(int cantLote) {
        this.cantLote = cantLote;
    }

    public boolean isImperfLote() {
        return imperfLote;
    }

    public void setImperfLote(boolean imperfLote) {
        this.imperfLote = imperfLote;
    }

    @Override
    public String toString() {
        return "LoteActivo{" + "codLote=" + codLote + ", tipoLote=" + tipoLote + ", cantLote=" + cantLote + ", cantProducidaLote=" + cantProducidaLote + ", ultimaMaquina=" + ultimaMaquina + ", imperfLote=" + imperfLote + '}';
    }
    
}

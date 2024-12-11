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
public class Lote {
    
    private int codLote;
    private int tipoLote;
    private int cantLote;
    private boolean imperfLote;
    private boolean activo;
    
    public Lote (int codL, int tipoL, int cantL, boolean imperfL, boolean loteActivo){
        this.codLote = codL;
        this.tipoLote = tipoL;
        this.cantLote = cantL;
        this.imperfLote = imperfL;
        this.activo = loteActivo;
    }

    public int getCodLote() {
        return this.codLote;
    }
    public boolean getActivo(){
        return this.activo;
    }
}

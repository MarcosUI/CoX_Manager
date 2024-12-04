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
    
    public Lote (int codL, int tipoL, int cantL, boolean imperfL){
        this.codLote = codL;
        this.tipoLote = tipoL;
        this.cantLote = cantL;
        this.imperfLote = imperfL;
    }

    public int getCodLote() {
        return this.codLote;
    }
}

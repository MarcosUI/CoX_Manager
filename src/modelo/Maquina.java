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
public class Maquina {
    
    private short codMaquina;
    private String nombreMaquina;
    private short numOperMaquina;
    
    public Maquina (short codM, String nomM, short numOperM){
        this.codMaquina = codM;
        this.nombreMaquina = nomM;
        this.numOperMaquina = numOperM;
    }

    public int getCodMaquina() {
        return this.codMaquina;
    }
    
    public short getNumOperMaquina(){
        return this.numOperMaquina;
    }
    
    public String getNombreMaquina(){
        return this.nombreMaquina;
    }
}

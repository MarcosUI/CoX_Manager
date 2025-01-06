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
public class Gestor {
    private int codGestor;
    private String nomGestor;

    public Gestor(int codGestor, String nomGestor) {
        this.codGestor = codGestor;
        this.nomGestor = nomGestor;
    }

    public int getCodGestor() {
        return codGestor;
    }

    public void setCodGestor(int codGestor) {
        this.codGestor = codGestor;
    }

    public String getNomGestor() {
        return nomGestor;
    }

    public void setNomGestor(String nomGestor) {
        this.nomGestor = nomGestor;
    }
    
    
}

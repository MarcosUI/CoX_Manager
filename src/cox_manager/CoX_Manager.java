/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cox_manager;

import excepciones.MyException;
import gestor.GestorBD;
import interfaz.Fichaje;
import interfaz.Informes;
import interfaz.ListaErrores;
import javax.swing.JOptionPane;

/**
 *
 * @author Marcos
 */
public class CoX_Manager {

    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        GestorBD conexion = new GestorBD("admin","CoX_Manager","jdbc:mysql://127.0.0.1:3306/","marcos");
        try{
            if(conexion.iniciarConexion()){
                JOptionPane.showMessageDialog(null, "Conexion iniciada correctamente");
                Fichaje fich = new Fichaje();
            }
            
        }
        catch(MyException ex){
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }
    
}

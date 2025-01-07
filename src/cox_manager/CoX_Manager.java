/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cox_manager;

import configuracion.Config;
import excepciones.MyException;
import gestor.GestorBD;
import interfaz.Fichaje;
import interfaz.Informes;
import interfaz.ListaErrores;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.JOptionPane;

/**
 *
 * @author Marcos
 */
public class CoX_Manager {

    public static void configuracion() throws MyException{
        String rutaFichero = "dist/config.txt";

        try (BufferedReader br = new BufferedReader(new FileReader(rutaFichero))) {
            String linea;

            while ((linea = br.readLine()) != null) {
                
                String[] partes = linea.split(":", 2);
                if (partes.length == 2) {
                    String clave = partes[0].trim();
                    String valor = partes[1].trim();

                    
                    switch (clave) {
                        case "jdbc":
                            Config.setJdbc(valor);
                            break;
                        case "bd":
                            Config.setNombreBD(valor);
                            break;
                        case "user":
                            Config.setUser(valor);
                            break;
                        case "password":
                            Config.setPassword(valor);
                            break;
                        case "rutaFicheroDiario":
                            Config.setRutaFichDiario(valor);
                            break;
                        case "rutaInformePDF":
                            Config.setRutaInformesPDF(valor);
                            break;
                        default:
                            System.out.println("Clave desconocida: " + clave);
                    }
                }
            }
        } catch (IOException e) {
            throw new MyException("Error al leer el fichero de configuración: " + e.getMessage());
        }
    }
    
    public static void main(String[] args) {
        
        try{
            configuracion();
            GestorBD conexion = new GestorBD(Config.user,Config.nombreBD,Config.jdbc,Config.password);
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

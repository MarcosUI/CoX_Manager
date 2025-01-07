/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package configuracion;

/**
 *
 * @author Marcos
 */
public class Config {
    public static String jdbc;
    public static String user;
    public static String password;
    public static String nombreBD;
    public static String rutaFichDiario;
    public static String rutaInformesPDF;
    public static String rutaInformesJasper;

    public static void setJdbc(String jdbc) {
        Config.jdbc = jdbc;
    }

    public static void setUser(String user) {
        Config.user = user;
    }

    public static void setPassword(String password) {
        Config.password = password;
    }

    public static void setNombreBD(String nombreBD) {
        Config.nombreBD = nombreBD;
    }

    public static void setRutaFichDiario(String rutaFichDiario) {
        Config.rutaFichDiario = rutaFichDiario;
    }

    public static void setRutaInformesPDF(String rutaInformesPDF) {
        Config.rutaInformesPDF = rutaInformesPDF;
    }

    public static void setRutaInformesJasper(String rutaInformesJasper) {
        Config.rutaInformesJasper = rutaInformesJasper;
    }
    
    
}

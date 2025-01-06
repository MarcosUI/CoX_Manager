/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jasper;

import excepciones.MyException;
import gestor.GestorBD;
import java.io.File;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import modelo.Gestor;
import modelo.LoteActivo;
import modelo.LoteTerminado;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.util.JRLoader;

/**
 *
 * @author Marcos
 */
public class GeneraInforme {
    private static Connection con;

    public GeneraInforme(Connection conn) {
        this.con = conn;
    }
    
    public String generarInforme() throws MyException{
        String rutaPDF = "C:\\Users\\Marcos\\Desktop\\CoX_Manager\\Informes_Generados\\";
        try {
            //Paso 1. Obtener clase del objeto JasperReports
            JasperReport jasperReport = (JasperReport) JRLoader.loadObjectFromFile("C:\\Users\\Marcos\\Desktop\\CoX_Manager\\src\\informes\\InformeLotes.jasper");

            // Paso 2 Crear clase objeto JRDataSource
            List<Gestor> listaGestor = new ArrayList<Gestor>();
            listaGestor.add(new Gestor(301, "Marcos Urriés"));
            JRBeanCollectionDataSource dataSourceGestor = new JRBeanCollectionDataSource(listaGestor);

            //Cargar datos para tabla de lotes terminados
            List<LoteTerminado> listaLotesTerminados = new ArrayList<LoteTerminado>();
            GestorBD.consultaLotesTerminados(this.con, listaLotesTerminados);
            JRBeanCollectionDataSource tableTerminadosDataSource = new JRBeanCollectionDataSource(listaLotesTerminados);

            // Cargar datos para tabla de lotes activos
            List<LoteActivo> listaLotesActivos = new ArrayList<LoteActivo>();
            GestorBD.consultaLotesActivos(con, listaLotesActivos);
            JRBeanCollectionDataSource tableActivosDataSource = new JRBeanCollectionDataSource(listaLotesActivos);

            // La última máquina usada se obtiene en una consulta a parte porque si no
            // la consulta junto al resto de datos del lote devuelve 0 como COD_MAQUINA
            // para todos los registros devueltos por el JDBC
            for (LoteActivo lote : listaLotesActivos) {
                int ultimaMaquina = GestorBD.consultaUltimaMaquina(con, lote.getCodLote());
                if (ultimaMaquina != 0) {

                    lote.setUltimaMaquina(ultimaMaquina);
                }
            }

            // Paso 3. Crear Hashmap para guardar los parametros
            Map<String, Object> parametros = new HashMap<String, Object>();
            parametros.put("TERMINADOS_DATA_SOURCE", tableTerminadosDataSource);
            parametros.put("ACTIVOS_DATA_SOURCE", tableActivosDataSource);

            // Paso 4. Crear objeto JasperFill para llenar objeto JasperReports con los parametros
            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parametros, dataSourceGestor);

            // Paso 5. Exportar a PDF
            // Primero nos aseguramos que el nombre del fichero pdf generado sea unico
            String nombreInforme = "Lotes-";
            String fecha = GestorBD.fechaGuiones();
            String numero = "";
            
            File ruta = new File("C:\\Users\\Marcos\\Desktop\\CoX_Manager\\Informes_Generados");
            if(ruta.exists() && ruta.isDirectory()){
                File[] numFicheros = ruta.listFiles();
                numero = String.valueOf(numFicheros.length);
            }
            nombreInforme += fecha + "-" + numero + ".pdf";
            JasperExportManager.exportReportToPdfFile(jasperPrint,rutaPDF + nombreInforme);
            
            return nombreInforme;

        } catch (JRException ex) {
            throw new MyException(ex.getMessage());
        } catch (MyException ex) {
            throw new MyException(ex.getMessage());
        }
    }
}

package org.ejercicios;

import javax.swing.*;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Ejercicio04 {
    public void escribirCadena(String cadena, String archivoAEscribir,String ruta) {
        File archivo = new File(ruta+archivoAEscribir);
        System.out.println("Ruta completa del archivo: " + archivo.getAbsolutePath());

        //Comprobamos si el archivo existe
        if(archivo.exists()) {

            String permisos = "El archivo tiene permisos de : \n "+
                    "Lectura : " + archivo.canRead() + "\n " +
                    "Escritura : " + archivo.canWrite() + "\n " +
                    "Ejecución : " + archivo.canExecute();
            JOptionPane.showMessageDialog(null, permisos);

            try {
                FileWriter escribir = new FileWriter(archivo, true);
                escribir.write(cadena+ "\n");
                JOptionPane.showMessageDialog(null, "Se ha escrito correctamente");
            } catch (IOException e) {
                JOptionPane.showMessageDialog(null, "Ocurrió un error: " + e.getMessage());
            }
        }else{
            JOptionPane.showMessageDialog(null, "El archivo "+ archivoAEscribir + " no existe");
        }
    }

}

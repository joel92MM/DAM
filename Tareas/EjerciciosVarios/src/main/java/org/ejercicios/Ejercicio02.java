package org.ejercicios;

import javax.swing.*;
import java.io.File;

public class Ejercicio02 {
    public void borrarArchivoExistente(String archivoABorrar) {
        File archivo = new File("src/main/resources/prueba/"+archivoABorrar);
        String mensaje = archivo.exists()
                ? (archivo.delete()
                ? "El archivo '" + archivoABorrar + "' ha sido eliminado con éxito."
                : "No se pudo eliminar el archivo '" + archivoABorrar + "'.")
                : "El archivo '" + archivoABorrar + "' no existe.";
        JOptionPane.showMessageDialog(null, mensaje);

    }
}

package org.ejercicios;

import javax.swing.*;
import java.io.File;

public class Ejercicio03 {
    public void crearDirectorio(String ruta, String nombreCarpeta) {
        System.out.println("Creando carpeta " + nombreCarpeta);
        File carpeta = new File(ruta+nombreCarpeta);

        boolean creado = carpeta.mkdir();
        String resultado=creado?"El directorio "+nombreCarpeta+" se ha creado correctamente":
                "El directorio "+nombreCarpeta+" no se ha creado correctamente";
        JOptionPane.showMessageDialog(null, resultado);
    }
}


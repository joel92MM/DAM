package org.ejercicios;

import javax.swing.*;
import java.io.File;
import java.io.IOException;

public class Ejercicio01 {
    public void crearArchivo(String archivo){
        // TODO: Crear archivo y verificar existencia
        // TODO: Eliminar archivo existente
        File file = new File("src/main/resources/prueba/" + archivo);

        if(file.exists()){
            JOptionPane.showMessageDialog(null, "El archivo ya existe, borrando archivo");
            file.delete();
        }
        try {
            file.createNewFile();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}

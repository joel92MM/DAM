package org.clases.ejercicio01;

import javax.swing.*;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class Crear {
        public void crearArchivo(List<Empleado> empleados, String archivo) throws IOException {
                String userHome = System.getProperty("user.home"); // Ruta al directorio de usuario
                File fichero = new File(userHome+"/Documentos/DAM/Tareas/Ejercicio01/" + archivo+".txt");
        try (
                BufferedWriter writer = new BufferedWriter(new FileWriter(fichero))) {
                for (Empleado empleado : empleados) {
                    writer.write(empleado.toString());
                    writer.newLine();
                }
                JOptionPane.showMessageDialog(null, "Archivo creado correctamente");
        }catch (IOException e){
                JOptionPane.showMessageDialog(null, e.getMessage());
                }
        }

}

package org.main.ejercicio01;

import org.clases.ejercicio01.Crear;
import org.clases.ejercicio01.Empleado;

import javax.swing.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        // Clase Scanner para que pida por pantalla

        Scanner sc = new Scanner(System.in);
        JOptionPane.showMessageDialog(null, "Bienvenido al programa de empleados");

        String userHome = System.getProperty("user.home"); // Ruta al directorio de usuario
        System.out.println(userHome);
        // Crear una lista de empleados
        List<Empleado> empleados = new ArrayList<>();


        //Preguntamos al usuario, cuantos empleados quiere guardar en el fichero
        int numeroEmpleados=Integer.parseInt(JOptionPane.showInputDialog("Ingrese el numero de empleados"));

        for (int i = 0; i < numeroEmpleados; i++) {
            int codigo=Integer.parseInt(JOptionPane.showInputDialog("Ingrese el codigo del empleado"));
            String nombre=JOptionPane.showInputDialog("Ingrese el nombre del empleado");
            String direccion=JOptionPane.showInputDialog("Ingrese la direccion del empleado");
            float salario=Float.parseFloat(JOptionPane.showInputDialog("Ingrese el salario del empleado"));
            float comision=Float.parseFloat(JOptionPane.showInputDialog("Ingrese la comision del empleado"));

            Empleado empleado = new Empleado(codigo,nombre,direccion,salario,comision);
            empleados.add(empleado);
            //System.out.println(empleado.toString());

/*            Empleado empleado = new Empleado();
            empleado.setCodigo(codigo);
            empleado.setDireccion(direccion);
            empleado.setNombre(nombre);
            empleado.setSalario(salario);
            empleado.setComision(comision);*/
        }

        //Creamos el archivo donde guardamos al empleado
        String nombre=JOptionPane.showInputDialog("Ingrese el nombre del archivo para guardar el empleado");
        Crear crear = new Crear();
        crear.crearArchivo(empleados, nombre);






    }
}
package org.main.ejercicio01;

import org.clases.ejercicio01.Crear;
import org.clases.ejercicio01.Empleado;

import javax.swing.*;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        // Clase Scanner para que pida por pantalla

        Scanner sc = new Scanner(System.in);
        JOptionPane.showMessageDialog(null, "Bienvenido al programa de empleados");
        // Crear una lista de empleados
        ArrayList<Empleado> empleados = new ArrayList<>();
        empleados.add(new Empleado(1, "Juan", "Calle 1", 10000, 1000));
        empleados.add(new Empleado(2, "Maria", "Calle 2", 15000, 1500));
        empleados.add(new Empleado(3, "Pedro", "Calle 3", 20000, 2000));
        empleados.add(new Empleado(4, "Ana", "Calle 4", 12000, 1200));
        empleados.add(new Empleado(5, "Jose", "Calle 5", 18000, 1800));

    try{
        //Creamos el archivo donde guardamos al empleado
        String nombre=JOptionPane.showInputDialog("Ingrese el nombre del archivo para guardar el empleado");
        String extension=JOptionPane.showInputDialog("Ingrese la extensión del archivo");
        RandomAccessFile aleatorio = new RandomAccessFile(nombre+"."+extension, "rw");

        //Crear crear = new Crear();
        for (Empleado empleado : empleados) {
            aleatorio.writeInt(empleado.getCodigo());

            StringBuffer sb = new StringBuffer(empleado.getNombre());
            sb.setLength(10);

            aleatorio.writeChars(sb.toString());

            sb=new StringBuffer(empleado.getDireccion());
            sb.setLength(20);
            aleatorio.writeChars(sb.toString());

            aleatorio.writeFloat(empleado.getSalario());
            aleatorio.writeFloat(empleado.getComision());
        }

        aleatorio.close();
        }catch(Exception e){
            System.out.println("Error: "+e.getMessage());
        }


    }
}
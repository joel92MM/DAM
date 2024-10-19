package org.main.ejercicio01;

import org.clases.ejercicio01.Crear;
import org.clases.ejercicio01.Empleado;
import org.clases.ejercicio01.Leer;
import org.clases.ejercicio01.XmlGenerator;

import javax.swing.*;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        // Clase Scanner o JpOptionPane para que pida por pantalla

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


        for (Empleado empleado : empleados) {
            //Escribimos el codigo del empleado
            aleatorio.writeInt(empleado.getCodigo());

            // Escribimos el nombre del empleado (cadena fija de 20 caracteres)
            StringBuffer sb = new StringBuffer(empleado.getNombre());
            sb.setLength(20);//Longitud del nombre
            aleatorio.writeChars(sb.toString());

            // Escribimos la direccion del empleado (cadena fija de 20 caracteres)
            sb=new StringBuffer(empleado.getDireccion());
            sb.setLength(20);//longitud de la direccion
            aleatorio.writeChars(sb.toString());

            // Escribimos el salario y la comisión (números de punto flotante)
            aleatorio.writeFloat(empleado.getSalario());
            aleatorio.writeFloat(empleado.getComision());
        }
        // Cerramos el archivo una vez que hemos terminado de escribir en él
        aleatorio.close();
        JOptionPane.showMessageDialog(null, "Archivo creado con éxito");

        }catch(Exception e){
            System.out.println("Error: "+e.getMessage());
        }

    //Leer el archivo que acabamos de crear
        String[] tiposDeAtributos = {"int", "string", "string", "float", "float"};
        String[] nombresDeAtributos = {"codigo", "nombre", "direccion", "salario", "comision"};

        String nombreArchivoXML=JOptionPane.showInputDialog("Ingrese el nombre del archivo xml para guardar la informacion de empleados.dat");
        String nombreElemento=JOptionPane.showInputDialog("Ingrese el nombre del elemento padre de los atributos");

        XmlGenerator generador = new XmlGenerator();
        generador.generateXml("EMPLEADOS.DAT", tiposDeAtributos, nombresDeAtributos, nombreArchivoXML,
                 nombreElemento);

    }
}
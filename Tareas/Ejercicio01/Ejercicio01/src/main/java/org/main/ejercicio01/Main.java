package org.main.ejercicio01;

import org.clases.ejercicio01.Empleado;
import org.clases.ejercicio01.XmlGenerator;
import org.clases.ejercicio02.ImprimirTodasEtiquetas;

import javax.swing.*;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
   public static void main(String[] args) throws IOException {
           // Mostrar menú de opciones
           String menu = "Seleccione una opción:\n" +
                   "1. Apartado 1\n" +
                   "2. Apartado 2\n" +
                   "3. Salir";
           String opcionMenu=JOptionPane.showInputDialog(menu);
           int opcion=Integer.parseInt(opcionMenu);

           while (opcion!=1 && opcion!=2 && opcion!=3) {
                opcion=Integer.parseInt(opcionMenu);

           }

           // Llamar al método correspondiente según la opción seleccionada
           switch (opcion) {
               case 1:
                   apartado1();
                   break;
               case 2:
                   apartado2();
                   break;
               case 3:
                   JOptionPane.showMessageDialog(null, "Saliendo del programa. ¡Hasta luego!");
                   break;
               default:
                   JOptionPane.showMessageDialog(null, "Opción inválida. Intente de nuevo.");
           }
    }

    public static void apartado1() {
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
    public static void apartado2() {
        //Apartado 2
        ImprimirTodasEtiquetas tecnicas = new ImprimirTodasEtiquetas();

        String[] opciones = {"Técnica DOM", "Técnica SAX"};

        int seleccion = JOptionPane.showOptionDialog(null,
                "Seleccione la técnica para imprimir las etiquetas:",
                "Selección de Técnica", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE,
                null, opciones, opciones[0]);

        // Ejecutar la técnica seleccionada usando switch
        switch (seleccion) {
            case 0: // Técnica DOM
                tecnicas.tecnicaDom();
                break;
            case 1: // Técnica SAX
                tecnicas.tecnicaSAX();
                break;
            case -1: // Opción cancelada
                JOptionPane.showMessageDialog(null, "Selección cancelada.");
                break;
            default:
                JOptionPane.showMessageDialog(null, "Selección no válida.");
                break;
        }
    }
}
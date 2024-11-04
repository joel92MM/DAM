package org.ejercicios;

import com.toedter.calendar.JDateChooser;
import org.ejercicios.clases.ConexionJDBC;

import javax.swing.*;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    private static ConexionJDBC conexion;
    private static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        mostrarMenu();
    }

    public static void mostrarMenu() {
        configurarConexion();
        int opcion;
        do {
            System.out.println("\nSeleccione una opción:");
            System.out.println("1. Mostrar información general de la base de datos");
            System.out.println("2. Mostrar información de la tabla pasajeros");
            System.out.println("3. Ver información de pasajeros de un vuelo");
            System.out.println("4. Insertar un vuelo");
            System.out.println("5. Borrar un vuelo");
            System.out.println("6. Modificar vuelos de fumadores a no fumadores");
            System.out.println("0. Salir");
            System.out.print("\nOpcion: ");
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1 -> mostrarInformacionDB();
                case 2 -> mostrarTablaPasajeros();
                case 3 -> verPasajeroDeVuelo();
                case 4 -> insertarVuelo();
                case 5 -> borrarVuelo();
                case 6 -> modificarVuelosNoFumadores();
                case 0 -> System.out.println("Saliendo...");
                default -> System.out.println("Opción no válida, intente de nuevo.");
            }
        } while (opcion != 0);

        scanner.close();
    }

    private static void configurarConexion() {
        String urljdbc = "jdbc:mysql://localhost:3306/aerolinea";
        conexion = new ConexionJDBC();

        //En mi caso, no puedo instalar MYSQL, por lo qu tengo que usar la base de datos mariadb
        //String urljdbc = "jdbc:mariadb://localhost:3306/aerolinea";
        String usuario = "root";
        String contrasena = "";

        conexion.detallesConexion(urljdbc, usuario, contrasena);
    }
    private static void mostrarInformacionDB() {
        try {
            conexion.abrirConexion();
            DatabaseMetaData dbmd = conexion.getConexion().getMetaData();

            //Obtener la información de la base de datos
            String nombreDB = dbmd.getDatabaseProductName();
            String nombreVersion = dbmd.getDatabaseProductVersion();
            String nombreDriver = dbmd.getDriverName();
            String nombreDriverVersion = dbmd.getDriverVersion();
            String nombreURL = dbmd.getURL();
            String usuarioDB = dbmd.getUserName();

            System.out.println("Nombre de la base de datos: " + nombreDB);
            System.out.println("Versión de la base de datos: " + nombreVersion);
            System.out.println("Nombre del driver: " + nombreDriver);
            System.out.println("Versión del driver: " + nombreDriverVersion);
            System.out.println("URL de la base de datos: " + nombreURL);
            System.out.println("Usuario de la base de datos: " + usuarioDB);

            conexion.cerrarConexion();
        } catch (SQLException | RuntimeException e) {
            System.out.println("Error al conectar con la base de datos: " + e.getMessage());
        }
    }

    private static void mostrarTablaPasajeros()  {
        try {
            conexion.abrirConexion();
            ResultSet consulta = conexion.ejecutarConsulta("SELECT * FROM PASAJEROS");
            while (consulta.next()) {
                System.out.println("Pasajero número" + consulta.getString("num") + ", codigo de vuelo "
                        +consulta.getString("cod_vuelo") + ", tipo de plaza " + consulta.getString("tipo_plaza") + ", fumador: " + consulta.getString("fumador") + ".\n");
            }
        } catch (SQLException |RuntimeException  e) {
            System.out.println("Error al conectar con la base de datos: " + e.getMessage());
        }
    }
    private static void verPasajeroDeVuelo()  {
        try {
            conexion.abrirConexion();
            ResultSet consulta = conexion.ejecutarConsulta("SELECT * FROM PASAJEROS WHERE cod_vuelo = 'SP-DC-438'");
            while (consulta.next()) {
                System.out.println("Pasajero número" + consulta.getString("num") + ", codigo de vuelo "
                        +consulta.getString("cod_vuelo") + ", tipo de plaza " + consulta.getString("tipo_plaza") + ", fumador: " + consulta.getString("fumador") + ".\n");
            }
        } catch (SQLException |RuntimeException  e) {
            System.out.println("Error al conectar con la base de datos: " + e.getMessage());
        }
    }

    private static void insertarVuelo()  {
        try {
            conexion.abrirConexion();

            String codVuelo = JOptionPane.showInputDialog("Ingrese el código de vuelo");

            String destino = JOptionPane.showInputDialog("Ingrese el destino del vuelo");
            String procedencia = JOptionPane.showInputDialog("Ingrese la procedencia del vuelo");
            int numero_plaza_fumadores = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el número de plazas fumadores"));
            int numero_plaza_nofumadores = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el número de plazas de no fumadores"));
            int plazas_turistas = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el número de plazas turistas (TU)"));
            int plazas_primera_clase = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el número de plazas de la primera clase (PR)"));

            // Configurar el selector de fecha
            JDateChooser dateChooser = new JDateChooser();
            dateChooser.setDateFormatString("yyyy-MM-dd");
            JOptionPane.showMessageDialog(null, dateChooser, "Seleccione la fecha de salida", JOptionPane.PLAIN_MESSAGE);
            Date fechaSeleccionada = dateChooser.getDate();

            // Captura de la hora en formato de texto
            String horaStr = JOptionPane.showInputDialog("Ingrese la hora de salida (formato HH:mm:ss):");

            // Combinar fecha y hora
            String fechaHoraStr = new SimpleDateFormat("yyyy-MM-dd").format(fechaSeleccionada) + " " + horaStr;
            Timestamp fechaHora = Timestamp.valueOf(fechaHoraStr);

            String sql="INSERT INTO VUELOS VALUES ('" + codVuelo + "', '" + fechaHoraStr + "', '" + destino.toUpperCase().trim() + "', '" + procedencia.toUpperCase().trim()
                    + "', '" + numero_plaza_fumadores  + "', '" + numero_plaza_nofumadores + "', '" + plazas_turistas + "', '" + plazas_primera_clase + "')";

            PreparedStatement consultaInsert = conexion.getConexion().prepareStatement(sql);
            consultaInsert.setString(1, codVuelo);
            consultaInsert.setString(2, fechaHoraStr);
            consultaInsert.setString(3, destino);
            consultaInsert.setString(4, procedencia);
            consultaInsert.setInt(5, numero_plaza_fumadores);
            consultaInsert.setInt(6, numero_plaza_nofumadores);
            consultaInsert.setInt(7, plazas_turistas);

            int filasInsertadas = consultaInsert.executeUpdate();

            if (filasInsertadas > 0) {
                System.out.println("Vuelo insertado correctamente.");
            } else {
                System.out.println("Error al insertar el vuelo.");
            }
            conexion.cerrarConexion();
        } catch (SQLException | RuntimeException e) {
            System.out.println("Error al conectar con la base de datos: " + e.getMessage());
        }

    }
    private static void borrarVuelo()  {
        try {
            conexion.abrirConexion();
            String codVuelo = JOptionPane.showInputDialog("Ingrese el código de vuelo");
            String sql="DELETE FROM VUELOS WHERE cod_vuelo = '" + codVuelo + "'";
            PreparedStatement consultaInsert = conexion.getConexion().prepareStatement(sql);
            int filasInsertadas = consultaInsert.executeUpdate();

            if (filasInsertadas > 0) {
                System.out.println("Vuelo borrado correctamente.");
            } else {
                System.out.println("Error al borrar el vuelo.");
            }
            conexion.cerrarConexion();
        } catch (SQLException | RuntimeException e) {
            System.out.println("Error al conectar con la base de datos: " + e.getMessage());
        }
    }
    private static void modificarVuelosNoFumadores()  {
        try {
            conexion.abrirConexion();
            String sql="UPDATE PASAJEROS SET FUMADOR = 'NO'";
            PreparedStatement consultaInsert = conexion.getConexion().prepareStatement(sql);
            int filasInsertadas = consultaInsert.executeUpdate();

            if (filasInsertadas > 0) {
                System.out.println("Vuelos modificados correctamente.");
            } else {
                System.out.println("Error al modificar el vuelo.");
            }
            conexion.cerrarConexion();
        } catch (SQLException | RuntimeException e) {
            System.out.println("Error al conectar con la base de datos: " + e.getMessage());
        }
    }
}
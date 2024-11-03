package org.ejercicios;

import org.ejercicios.clases.ConexionJDBC;

import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;
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
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1 -> mostrarInformacionDB();
               // case 2 -> mostrarTablaPasajeros();
                //  case 3 -> verPasajerosDeVuelo();
               // case 4 -> insertarVuelo();
               // case 5 -> borrarVuelo();
               // case 6 -> modificarVuelosNoFumadores();
                case 0 -> System.out.println("Saliendo...");
                default -> System.out.println("Opción no válida, intente de nuevo.");
            }
        } while (opcion != 0);

        scanner.close();
    }

    private static void configurarConexion() {
        //String urljdbc = "jdbc:mysql://localhost:3306/aerolinea";
        conexion = new ConexionJDBC();

        String urljdbc = "jdbc:mariadb://localhost:3306/aerolinea";
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
}
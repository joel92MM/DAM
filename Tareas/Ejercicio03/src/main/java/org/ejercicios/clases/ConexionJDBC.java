package org.ejercicios.clases;

import java.sql.*;

public class ConexionJDBC {
    private Connection conexion;
    private String urljdbc;
    private String usuario;
    private String contrasena;
//    public void conectorJDBC(String urljdbc, String usuario, String contrasena) {
    public void conectorJDBC() {

        Connection conexion = null;
            try {
                // Establecemos la conexión con la BD de MariaDB
                String urljdbc = "jdbc:mariadb://localhost:3306/aerolinea"; // Cambia "nombre_base_datos" al nombre de tu BD
                String usuario = "root";
                String contrasena = "";

                // Conexión con MariaDB
                conexion = DriverManager.getConnection(urljdbc, usuario, contrasena);
                System.out.println("Conexión exitosa a MariaDB!");
                Statement sentencia = conexion.createStatement();

                String sql = "SELECT COD_VUELO, DESTINO, PROCEDENCIA FROM VUELOS";
                ResultSet resultado = sentencia.executeQuery(sql);

                // Procesar y mostrar resultados
                while (resultado.next()) {
                    String id = resultado.getString("COD_VUELO");           // Cambia el nombre de columna si es necesario
                    String destino = resultado.getString("DESTINO");
                    String procedencia = resultado.getString("PROCEDENCIA");

                    System.out.println("COD_VUELO: " + id + ", Destino: " + destino + ", Procedencia: " + procedencia);
                }

                // Cerrar conexión
                conexion.close();
            } catch (SQLException cn) {
                cn.printStackTrace();
            }

        }

    public void detallesConexion(String urljdbc, String usuario, String contrasena){
        this.urljdbc = urljdbc;
        this.usuario = usuario;
        this.contrasena = contrasena;
    }
    public void abrirConexion() throws SQLException {
        if (conexion == null || conexion.isClosed()) {
            conexion = DriverManager.getConnection(urljdbc, usuario, contrasena);
            System.out.println("Conexión exitosa a la base de datos establecida!");
        }
    }
    public void cerrarConexion() throws SQLException {
        if (conexion!= null && !conexion.isClosed()) {
            conexion.close();
            System.out.println("Conexión cerrada con exito!");
        }
    }
    public ResultSet ejecutarConsulta(String sql) throws SQLException {
        abrirConexion();
        Statement sentencia = conexion.createStatement();
        return sentencia.executeQuery(sql);
    }
    public Connection getConexion() {
        return conexion;
    }

}


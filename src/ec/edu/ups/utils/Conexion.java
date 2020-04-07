/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.ups.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author nacip
 */
public class Conexion {
   
     private Connection conexion = null;

    public Connection conectar() {

        String url = "jdbc:mysql://localhost:3306/contacto";
        String user = "root";
        String pass = "cuenca";
        try {
            conexion = DriverManager.getConnection(url, user, pass);
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error al conectar" + e);
        }
        return conexion;

    }

    public void cerrarConexion() {
        try {
            conexion.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}

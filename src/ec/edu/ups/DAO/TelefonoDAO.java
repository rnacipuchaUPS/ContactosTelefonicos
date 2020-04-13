/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.ups.DAO;

import ec.edu.ups.EN.PersonaEN;
import ec.edu.ups.EN.TelefonoEN;
import ec.edu.ups.utils.Conexion;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author nacip
 */
public class TelefonoDAO {
    private Conexion con;

    public boolean insert(TelefonoEN telefono) {
        boolean i = false;
        con = new Conexion();
        PreparedStatement statement = null;
        PersonaEN p = new PersonaEN();

        try {
            String sql = "insert into telefono( numero, tipo, codigoP) values(?, ?, ?);";
            statement = con.conectar().prepareStatement(sql);
            statement.setString(1, telefono.getNumero());
            statement.setString(2, telefono.getTipo());
            statement.setInt(3, telefono.getCodigoP());
            i = statement.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                statement.close();
                con.cerrarConexion();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return i;
    }
    public int ultimoNumero() {
        Statement statement = null;
        ResultSet result = null;
        con = new Conexion();
        int numero = 0;
        try {
            String sql = "select max(codigoP) from persona;";
            statement = con.conectar().createStatement();
            result = statement.executeQuery(sql);
            while (result.next()) {
                numero = result.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                result.close();
                statement.close();
                con.cerrarConexion();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        numero = numero;
        return numero;
    }
 
}

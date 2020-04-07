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
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author nacip
 */
public class PersonaDAO {
    private Conexion con;
    
    public int insert(PersonaEN persona) { 
        boolean i = false;
        con = new Conexion();
        PreparedStatement statement = null;
        TelefonoEN t = new TelefonoEN();
        List<TelefonoEN> telefonos = new ArrayList<TelefonoEN>();
        try {
            String sql = "insert into persona( cedula, nombre, apellido) values(?, ?, ?);";
            statement = con.conectar().prepareStatement(sql);
            statement.setString(1, persona.getCedula().toString());
            statement.setString(2, persona.getNombre().toString());
            statement.setString(3, persona.getApellido().toString());
            i = statement.execute();
        } catch (SQLException e) {
            System.out.println("errorTelefono>>" + e);
            e.printStackTrace();
        } finally {
            try {
                statement.close();
                con.cerrarConexion();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return 0;
    }

}

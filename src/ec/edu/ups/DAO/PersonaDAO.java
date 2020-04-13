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
public class PersonaDAO {
    private Conexion con;
    
    public int insert(PersonaEN persona) throws Exception { 
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
            e.printStackTrace();
            throw new Exception("Error al insertar");
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
    
        public ArrayList<PersonaEN> listarPersonas() {
        ArrayList<PersonaEN> lista = new ArrayList<PersonaEN>();
        Statement statement = null;
        ResultSet result = null;
        con = new Conexion();
        try {
            String sql = "select cedula, nombre, apellido FROM persona";
            statement = con.conectar().createStatement();
            result = statement.executeQuery(sql);
            while (result.next()) {
                PersonaEN t = new PersonaEN();
                t.setCedula(result.getString(1));
                t.setNombre(result.getString(2));
                t.setApellido(result.getString(3));
                lista.add(t);
            }

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
        return lista;
    }
        
        public ArrayList<PersonaEN> listaP(){
            ArrayList<PersonaEN> list = new ArrayList<PersonaEN>();
            
            Statement statement1 = null;
            Statement statement2 = null;
            ResultSet result1 = null;
            ResultSet result2 = null;
            con = new Conexion();
            String sql1 = "SELECT * FROM persona";
            String sql2 = "SELECT * FROM telefono WHERE codigoP=";
            try {
                statement1 = con.conectar().createStatement();
                statement2 = con.conectar().createStatement();
                result1 = statement1.executeQuery(sql1);
                result1.setFetchDirection(ResultSet.FETCH_FORWARD);
                while (result1.next()) {
                    PersonaEN p = new PersonaEN();
                    ArrayList<TelefonoEN> list1 = new ArrayList<TelefonoEN>();
                    TelefonoDAO td = new TelefonoDAO();
                    p.setCodigo(result1.getInt("codigoP"));
                    p.setCedula(result1.getString("cedula"));
                    p.setNombre(result1.getString("nombre"));
                    p.setApellido(result1.getString("apellido"));
                    result2 = statement2.executeQuery(sql2+"'"+p.getCodigo()+"'");
                    result2.setFetchDirection(ResultSet.FETCH_FORWARD);
                    while (result2.next()) {
                        TelefonoEN t = new TelefonoEN();
                        t.setCodigo(result2.getInt("codigoT"));
                        t.setNumero(result2.getString("numero"));
                        t.setTipo(result2.getString("tipo"));
                        list1.add(t);
                        p.setListaTelefonos(list1);
                    }
                    list.add(p);
                }
            } catch (SQLException e) {
                
                e.printStackTrace();
            }
            return list;
        }
    public PersonaEN buscarPersona(String cedula) {
        TelefonoDAO vd = new TelefonoDAO();
        PreparedStatement statement = null;
        ResultSet result = null;
        PersonaEN p= new PersonaEN();
        con = new Conexion();
        TelefonoEN v = null;
        try {
            String sql = "select cedula, nombre, apellido from persona where cedula = ?;";
            statement = con.conectar().prepareStatement(sql);
            statement.setString(1, cedula);
            result = statement.executeQuery();
            while (result.next()) {
                p.setCedula(result.getString(1));
                p.setNombre(result.getString(2));
                p.setApellido(result.getString(3));             
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                result.close();
                statement.close();
                con.cerrarConexion();
            } catch (Exception e) {
            }
        }
        return p;
    }
     
}

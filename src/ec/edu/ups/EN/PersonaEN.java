/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.ups.EN;

import java.util.List;

/**
 *
 * @author nacip
 */
public class PersonaEN {
    private int codigo;
    private String nombre;
    private String cedula;
    private String apellido;
    private List<TelefonoEN> listaTelefonos; 

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public List<TelefonoEN> getListaTelefonos() {
        return listaTelefonos;
    }

    public void setListaTelefonos(List<TelefonoEN> listaTelefonos) {
        this.listaTelefonos = listaTelefonos;
    }

    @Override
    public String toString() {
        return "PersonaEN{" + "codigo=" + codigo + ", nombre=" + nombre + ", cedula=" + cedula + ", apellido=" + apellido + ", listaTelefonos=" + listaTelefonos + '}';
    }
    
    
}

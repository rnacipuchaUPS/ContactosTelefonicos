/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.ups.ON;

import ec.edu.ups.DAO.PersonaDAO;
import ec.edu.ups.DAO.TelefonoDAO;
import ec.edu.ups.EN.PersonaEN;
import ec.edu.ups.EN.TelefonoEN;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author nacip
 */
public class ContactoON {
    private PersonaDAO pDAO = new PersonaDAO();
    private TelefonoDAO tDAO  = new TelefonoDAO();

    public void guardarContacto(PersonaEN persona) {
        TelefonoEN t = new TelefonoEN();
        List<TelefonoEN> telefonos = new ArrayList<TelefonoEN>();
        t.setNumero(t.getNumero());
        t.setTipo(t.getTipo());
        telefonos.add(t);
         System.out.println("persona>>>>" + persona.toString());
        persona.getListaTelefonos().add(t);       
        int c = pDAO.insert(persona);;
        for(TelefonoEN te: persona.getListaTelefonos()){
            te.setCodigoP(c);
            
            tDAO.insert(te);
        }      
    }

    public List<PersonaEN> buscarContacto(String cedula) {

        return null;
    }

    public boolean validarcedula(){
        return true;
    }
}

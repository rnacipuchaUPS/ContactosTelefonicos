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
        if(validarCedula(persona.getCedula())){
       // t.setNumero(t.getNumero());
        //t.setTipo(t.getTipo());
        //telefonos.add(t);
         System.out.println("persona>>>>" + persona.toString());
        persona.getListaTelefonos().add(t);       
        int c = pDAO.insert(persona);;
        for(TelefonoEN te: persona.getListaTelefonos()){
            te.setCodigoP(1);
            tDAO.insert(te);
        }  
        }else{
            System.out.println("error de cedula");
        }
    }

    public List<PersonaEN> buscarContacto(String cedula) {

        return null;
    }

    public boolean validarCedula(String cedula) {
        boolean cedulaCorrecta = false;
        int[] coeficientes = {2, 1, 2, 1, 2, 1, 2, 1, 2};
        int tercerDigito = Integer.parseInt(cedula.substring(2, 3));
        try {
            if (tercerDigito < 6) {
                int verificador = Integer.parseInt(cedula.substring(9, 10));
                int suma = 0;
                int digito = 0;
                for (int i = 0; i < (cedula.length() - 1); i++) {
                    digito = Integer.parseInt(cedula.substring(i, i + 1)) * coeficientes[i];
                    suma = suma + ((digito % 10) + (digito / 10));
                }

                if ((suma % 10 == 0) && (suma % 10 == verificador)) {
                    cedulaCorrecta = true;
                } else {
                    cedulaCorrecta = (10 - (suma % 10)) == verificador;
                }
            } else {
                cedulaCorrecta = false;
            }
        } catch (NumberFormatException e) {
            cedulaCorrecta = false;
        }
        return cedulaCorrecta;
    }

}

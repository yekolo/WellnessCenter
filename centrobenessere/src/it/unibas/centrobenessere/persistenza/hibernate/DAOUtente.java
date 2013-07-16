/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unibas.centrobenessere.persistenza.hibernate;

import it.unibas.centrobenessere.modello.Utente;
import it.unibas.centrobenessere.persistenza.IDAOUtente;

/**
 *
 * @author Utente
 */
public class DAOUtente extends DAOGenericoHibernate<Utente> implements IDAOUtente{
    
    public DAOUtente(){
        super(Utente.class);
    }
    
}

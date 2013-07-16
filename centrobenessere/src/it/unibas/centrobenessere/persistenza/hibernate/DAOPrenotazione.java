/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unibas.centrobenessere.persistenza.hibernate;

import it.unibas.centrobenessere.modello.Prenotazione;
import it.unibas.centrobenessere.persistenza.IDAOPrenotazione;

/**
 *
 * @author Utente
 */
public class DAOPrenotazione extends DAOGenericoHibernate<Prenotazione> implements IDAOPrenotazione{
    
    public DAOPrenotazione(){
     super(Prenotazione.class);
    }
    
}

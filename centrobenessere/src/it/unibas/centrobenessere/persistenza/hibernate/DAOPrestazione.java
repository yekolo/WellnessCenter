/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unibas.centrobenessere.persistenza.hibernate;

import it.unibas.centrobenessere.modello.Prestazione;
import it.unibas.centrobenessere.persistenza.IDAOPrestazione;

/**
 *
 * @author Utente
 */
public class DAOPrestazione extends DAOGenericoHibernate<Prestazione> implements IDAOPrestazione{
    
    public DAOPrestazione(){
        super(Prestazione.class);
    }
    
    
}

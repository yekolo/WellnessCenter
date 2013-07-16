/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unibas.centrobenessere.controllo;

import it.unibas.centrobenessere.modello.Modello;
import it.unibas.centrobenessere.vista.VistaPrenotazione;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 *
 * @author Utente
 */
public class ControlloPrenotazione {
    
    private Modello modello;
    private VistaPrenotazione vistaPrenotazione;
    private String messaggio;
    private Log logger = LogFactory.getLog(ControlloPrenotazione.class);


    public String getMessaggio() {
        return messaggio;
    }

    public void setMessaggio(String messaggio) {
        this.messaggio = messaggio;
    }

    public Modello getModello() {
        return modello;
    }

    public void setModello(Modello modello) {
        this.modello = modello;
    }

    public VistaPrenotazione getVistaPrenotazione() {
        return vistaPrenotazione;
    }

    public void setVistaPrenotazione(VistaPrenotazione vistaPrenotazione) {
        this.vistaPrenotazione = vistaPrenotazione;
    }
    
   public String fine(){
       return "procedi";
   
   }
 
    
    
}

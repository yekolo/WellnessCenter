/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unibas.centrobenessere.vista;

import it.unibas.centrobenessere.modello.Prenotazione;
import java.util.List;
import javax.faces.component.UIData;

/**
 *
 * @author Utente
 */
public class VistaPrenotazione {
    
    private List<Prenotazione> listaPrenotazioni;
    private UIData tabellaPrenotazioni ;

    public List<Prenotazione> getListaPrenotazioni() {
        return listaPrenotazioni;
    }

    public void setListaPrenotazioni(List<Prenotazione> listaPrenotazioni) {
        this.listaPrenotazioni = listaPrenotazioni;
    }

    public UIData getTabellaPrenotazioni() {
        return tabellaPrenotazioni;
    }

    public void setTabellaPrenotazioni(UIData tabellaPrenotazioni) {
        this.tabellaPrenotazioni = tabellaPrenotazioni;
    }  
    
    
    
}

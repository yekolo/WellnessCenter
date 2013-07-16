/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unibas.centrobenessere.vista;

import it.unibas.centrobenessere.modello.Prestazione;
import java.util.Date;
import java.util.List;
import javax.faces.component.UIData;

/**
 *
 * @author Utente
 */
public class VistaPrestazione {
    
    private List<Prestazione> listaPrestazioni;
    private UIData tabellaPrestazioni;
    private boolean selezionato;
    private Date dataEOra;

    public Date getDataEOra() {
        return dataEOra;
    }

    public void setDataEOra(Date dataEOra) {
        this.dataEOra = dataEOra;
    }   

    public boolean isSelezionato() {
        return selezionato;
    }

    public void setSelezionato(boolean selezionato) {
        this.selezionato = selezionato;
    }
    
    
    public List<Prestazione> getListaPrestazioni() {
        return listaPrestazioni;
    }

    public void setListaPrestazioni(List<Prestazione> listaPrestazioni) {
        this.listaPrestazioni = listaPrestazioni;
    }

    public UIData getTabellaPrestazioni() {
        return tabellaPrestazioni;
    }

    public void setTabellaPrestazioni(UIData tabellaPrestazioni) {
        this.tabellaPrestazioni = tabellaPrestazioni;
    }
    
}

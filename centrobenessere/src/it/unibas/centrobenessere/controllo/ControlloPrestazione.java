/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unibas.centrobenessere.controllo;

import it.unibas.centrobenessere.modello.Modello;
import it.unibas.centrobenessere.modello.Prenotazione;
import it.unibas.centrobenessere.modello.Prestazione;
import it.unibas.centrobenessere.modello.Utente;
import it.unibas.centrobenessere.persistenza.DAOException;
import it.unibas.centrobenessere.persistenza.IDAOPrenotazione;
import it.unibas.centrobenessere.persistenza.IDAOUtente;
import it.unibas.centrobenessere.vista.VistaPrenotazione;
import it.unibas.centrobenessere.vista.VistaPrestazione;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 *
 * @author Utente
 */
public class ControlloPrestazione {
    
    private Modello modello;
    private VistaPrestazione vistaPrestazione;
    private VistaPrenotazione vistaPrenotazione;
    private IDAOPrenotazione daoPrenotazione;
    private IDAOUtente daoUtente;
    private String messaggio;
    private Log logger = LogFactory.getLog(ControlloPrestazione.class);

    public IDAOUtente getDaoUtente() {
        return daoUtente;
    }

    public void setDaoUtente(IDAOUtente daoUtente) {
        this.daoUtente = daoUtente;
    }

    public VistaPrenotazione getVistaPrenotazione() {
        return vistaPrenotazione;
    }

    public void setVistaPrenotazione(VistaPrenotazione vistaPrenotazione) {
        this.vistaPrenotazione = vistaPrenotazione;
    }

    public IDAOPrenotazione getDaoPrenotazione() {
        return daoPrenotazione;
    }

    public void setDaoPrenotazione(IDAOPrenotazione daoPrenotazione) {
        this.daoPrenotazione = daoPrenotazione;
    }

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

    public VistaPrestazione getVistaPrestazione() {
        return vistaPrestazione;
    }

    public void setVistaPrestazione(VistaPrestazione vistaPrestazione) {
        this.vistaPrestazione = vistaPrestazione;
    }

    public void selezionaPrestazione() {
        this.vistaPrestazione.setSelezionato(true);

    }

    public void aggiungiPrestazione() {
        try {
            Utente utente = (Utente)this.modello.getNuovoUtente();
            Prestazione prestazione = (Prestazione) this.vistaPrestazione.getTabellaPrestazioni().getRowData();
            Prenotazione prenotazione = new Prenotazione();
            prenotazione.setDataPrenotazione(this.vistaPrestazione.getDataEOra());
            prenotazione.setPrestazione(prestazione);
            prenotazione.setUtente(utente);
            
            logger.info("la data della prenotazione e : " + prenotazione.getDataPrenotazione() + " " + prenotazione.getPrestazione() + " " + prestazione.getTipo());
            this.modello.getNuovoUtente().getListaPrenotazioni().add(prenotazione);
            this.daoUtente.makePersistent(this.modello.getNuovoUtente());
            this.daoUtente.makePersistent(utente);
            logger.info("INFOOOOOOOO   : " + this.modello.getNuovoUtente().getListaPrenotazioni().size());
            this.vistaPrestazione.setSelezionato(false);
        } catch (DAOException ex) {
            Logger.getLogger(ControlloPrestazione.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public String prenotaPrestazioni() {
        try {
            Utente utente = (Utente)this.modello.getNuovoUtente();
            Prestazione prestazione = (Prestazione) this.vistaPrestazione.getTabellaPrestazioni().getRowData();
            logger.info("il tipo della prestazione e :  " + prestazione.getTipo());
            Prenotazione prenotazione = new Prenotazione();
            prenotazione.setDataPrenotazione(this.vistaPrestazione.getDataEOra());
            prenotazione.setPrestazione(prestazione);
            logger.info("prenotazione per queale prestazione ???????  : " + prenotazione.getPrestazione().getTipo());
            prenotazione.setUtente(utente);
            logger.info("la data della prenotazione e : " + prenotazione.getDataPrenotazione() + " " + prenotazione.getPrestazione() + " " + prestazione.getTipo());
            this.modello.getNuovoUtente().getListaPrenotazioni().add(prenotazione);
            this.daoUtente.makePersistent(utente);
            logger.info("INFOOOOOOOO   : " + this.modello.getNuovoUtente().getListaPrenotazioni().size());
            logger.info("INFOOOOOOOO   : " + utente.getNome() + " " + "numero listaPrenotazione dell'utente  : "+ utente.getListaPrenotazioni().size());            
            List<Prenotazione> lista = utente.getListaPrenotazioni();
            this.vistaPrenotazione.setListaPrenotazioni(lista);
            return "dettagli";
        } catch (DAOException ex) {
            Logger.getLogger(ControlloPrestazione.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }

    }
    
}

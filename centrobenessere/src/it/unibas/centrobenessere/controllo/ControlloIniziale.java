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
import it.unibas.centrobenessere.persistenza.IDAOPrestazione;
import it.unibas.centrobenessere.persistenza.IDAOUtente;
import it.unibas.centrobenessere.vista.VistaIniziale;
import it.unibas.centrobenessere.vista.VistaPrestazione;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 *
 * @author Utente
 */
public class ControlloIniziale {
    
    private Modello modello;
    private VistaIniziale vistaIniziale;
    private VistaPrestazione vistaPrestazione;
    private IDAOUtente daoUtente;
    private IDAOPrestazione daoPrestazione;
    private String messaggio;
    private Log logger = LogFactory.getLog(ControlloIniziale.class);

    public IDAOUtente getDaoUtente() {
        return daoUtente;
    }

    public void setDaoUtente(IDAOUtente daoUtente) {
        this.daoUtente = daoUtente;
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

    public VistaIniziale getVistaIniziale() {
        return vistaIniziale;
    }

    public void setVistaIniziale(VistaIniziale vistaIniziale) {
        this.vistaIniziale = vistaIniziale;
    }

    public VistaPrestazione getVistaPrestazione() {
        return vistaPrestazione;
    }

    public void setVistaPrestazione(VistaPrestazione vistaPrestazione) {
        this.vistaPrestazione = vistaPrestazione;
    }

    public IDAOPrestazione getDaoPrestazione() {
        return daoPrestazione;
    }

    public void setDaoPrestazione(IDAOPrestazione daoPrestazione) {
        this.daoPrestazione = daoPrestazione;
    }

    public String creaUtente() {
        try {
            Utente utente = new Utente();
            utente.setNome(this.vistaIniziale.getNome());
            utente.setCognome(this.vistaIniziale.getCognome());
            utente.setCodiceFiscale(this.vistaIniziale.getCodiceFiscale());
            utente.setSesso(this.vistaIniziale.getSesso());
            logger.info("UTENTE CREATO " + utente.getNome() + utente.getSesso());
            if (!utente.getNome().equalsIgnoreCase("") &&  !utente.getCognome().equalsIgnoreCase("") && !utente.getSesso().equalsIgnoreCase("") && !utente.getCodiceFiscale().equalsIgnoreCase("")) {
                utente.setListaPrenotazioni(new ArrayList<Prenotazione>());
                this.modello.setNuovoUtente(utente);
                this.daoUtente.makePersistent(utente);                
                List<Prestazione> lista = this.daoPrestazione.findAll();
                this.vistaPrestazione.setListaPrestazioni(lista);
                return "prenota";
            } else {
                this.setMessaggio("ERRORE, devi inserire tutti i campi ");
                return null;
            }
        } catch (DAOException e) {
            logger.info("problema con la base di dati");
            return null;
        }

    }
    
}

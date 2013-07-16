/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unibas.centrobenessere.modello;

import java.util.Date;
import javax.persistence.*;

/**
 *
 * @author Utente
 */
@Entity
public class Prenotazione {
    
     private Long id;
    private Date dataPrenotazione;
    private Utente utente;
    private Prestazione prestazione;   
    
    
    @Id @GeneratedValue(strategy= GenerationType.AUTO)
    public Long getId() {
        return id;
    }

       


    public void setId(Long id) {
        this.id = id;
    }

    @Temporal(TemporalType.TIMESTAMP)
    public Date getDataPrenotazione() {
        return dataPrenotazione;
    }

    public void setDataPrenotazione(Date dataPrenotazione) {
        this.dataPrenotazione = dataPrenotazione;
    }

    @OneToOne
    public Prestazione getPrestazione() {
        return prestazione;
    }

    public void setPrestazione(Prestazione prestazione) {
        this.prestazione = prestazione;
    }

    @ManyToOne
    public Utente getUtente() {
        return utente;
    }

    public void setUtente(Utente utente) {
        this.utente = utente;
    }
    
    
    
    
}

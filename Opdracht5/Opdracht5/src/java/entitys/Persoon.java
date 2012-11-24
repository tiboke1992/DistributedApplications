/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entitys;

import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 *
 * @author stinson
 */
@Entity
public class Persoon implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String naam;
    private String voornaam;
    private String klasnr;
    @ManyToOne(targetEntity = Klas.class, cascade = {CascadeType.PERSIST, CascadeType.MERGE}, fetch = FetchType.EAGER)
    private Klas klas;

    public Klas getKlas() {
        return klas;
    }

    public void setKlas(Klas klas) {
        this.klas = klas;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNaam() {
        return naam;
    }

    public void setNaam(String naam) {
        this.naam = naam;
    }

    public String getVoornaam() {
        return voornaam;
    }

    public void setVoornaam(String voornaam) {
        this.voornaam = voornaam;
    }

    public String getKlasnr() {
        return klasnr;
    }

    public void setKlasnr(String klasnr) {
        this.klasnr = klasnr;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Persoon)) {
            return false;
        }
        Persoon other = (Persoon) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entitys.Persoon[ id=" + id + " ]";
    }
    
    
 
}

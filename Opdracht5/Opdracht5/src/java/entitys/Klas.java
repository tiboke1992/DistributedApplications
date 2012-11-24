/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entitys;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;


/**
 *
 * @author stinson
 */
@Entity
public class Klas implements Serializable {

    
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String klasNaam;
    private String klasNR;
    @OneToMany(mappedBy="klas", cascade = {CascadeType.PERSIST, CascadeType.MERGE},fetch= FetchType.EAGER)
    private List<Persoon> klasLijst;
    
    public List<Persoon> getKlasLijst() {
        return klasLijst;
    }

    public void setKlasLijst(List<Persoon> klasLijst) {
        this.klasLijst = klasLijst;
    }
   
  
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getKlasNaam() {
        return klasNaam;
    }

    public void setKlasNaam(String klasNaam) {
        this.klasNaam = klasNaam;
    }

    public String getKlasNR() {
        return klasNR;
    }

    public void setKlasNR(String klasNR) {
        this.klasNR = klasNR;
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
        if (!(object instanceof Klas)) {
            return false;
        }
        Klas other = (Klas) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entitys.Klas[ id=" + id + " ]";
    }
    
    public void voegPersoonToe(Persoon persoon){
        klasLijst.add(persoon);
    }
    
}

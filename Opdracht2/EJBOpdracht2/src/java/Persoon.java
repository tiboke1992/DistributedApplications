
import java.io.Serializable;


public class Persoon implements Serializable{
    private String naam;
    private String voornaam;
    private String woonplaats;
    private Klas klas;
    
    public Persoon(){
        this(null,null,null);
    }
    
    public Persoon(String naam, String voornaam, String woonplaats){
        setNaam(naam);
        setVoornaam(voornaam);
        setWoonplaats(woonplaats);
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

    public String getWoonplaats() {
        return woonplaats;
    }

    public void setWoonplaats(String woonplaats) {
        this.woonplaats = woonplaats;
    }
    
    public void setKlas(Klas klas){
        this.klas = klas;
    }
    
    public Klas getKlas(){
        return this.klas;
    }
    
   public String toString(){
       return "Voornaam: " + this.getVoornaam() + " Naam: " + this.getNaam() + " Woonplaats: " + this.getWoonplaats();
   }
}


import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;


public class Main {
    public static void main(String[] args){
        try {
            Context c = new InitialContext();
            ObjectBeanRemote o = (ObjectBeanRemote)c.lookup("java:global/EJBOpdracht2/ObjectBeanBean");
            Klas k = o.geefTrosObjecten();
            print(k);
        } catch (NamingException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public static void print(Klas k){
        System.out.println(k.toString());
        for(Persoon p : k.geefLijst()){
            System.out.println(p.toString());
        }
    }
}

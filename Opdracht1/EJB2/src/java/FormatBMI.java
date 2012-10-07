
import javax.ejb.Stateless;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

@Stateless
public class FormatBMI implements FormatBMIInterface {

    @Override
    public String calcBMI(int gewicht, double lengte) {
        String result = null;
        String bijkomend = "";
        Object o;
        Context c;
        try {
            c = new InitialContext();
            o = c.lookup("java:global/EJB1/BMIBean");
            BMIInterface bmi = (BMIInterface) o;
            int b = bmi.berekenBMI(gewicht, lengte);
            if(b < 18){
                bijkomend = "ondergewicht";
            }else if(b > 18 && b < 25){
                bijkomend = "normaal gewicht";
            }else if(b > 25 && b < 30){
                bijkomend = "Overgewicht";
            }else if (b > 30 && b < 40){
                bijkomend = "Zwaarlijvig";
            }else if(b > 40){
                bijkomend = "Ernstige zwaarlijvigheid";
            }
            result = "Je BMI bedraagt: " + b + " Dit betekend : " + bijkomend;
        } catch (NamingException ex) {
        }
        return result;
    }
}

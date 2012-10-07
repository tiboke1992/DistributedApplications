
import javax.ejb.Remote;

@Remote
public interface FormatBMIInterface {
    String calcBMI(int gewicht, double lengte);
}

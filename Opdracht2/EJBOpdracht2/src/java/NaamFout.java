
import javax.ejb.ApplicationException;

@ApplicationException
public class NaamFout extends IllegalArgumentException {
    public NaamFout(){
    }
    public NaamFout(String msg){
        super(msg);
    }
}

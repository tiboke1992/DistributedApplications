


import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;


public class TheMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Context c;
        Object o;
        try{
            c = new InitialContext();
            o = c.lookup("java:global/EJB2/FormatBMI");
            FormatBMIInterface b = (FormatBMIInterface)o;
            System.out.println(b.calcBMI(40, 1.75));
            System.out.println(b.calcBMI(80, 1.75));
            System.out.println(b.calcBMI(120, 1.75));
            System.out.println(b.calcBMI(200, 1.75));
        }catch(NamingException ex){
        }
    }
}

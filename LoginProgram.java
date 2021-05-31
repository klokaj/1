
import java.awt.*;
import java.io.*;



/**
 *
 * @author Szymon
 */
public class LoginProgram {
    public static void main(String[] argv){
        Login log = new Login ("ala", "makota");

        try{
            InputStreamReader rd = new InputStreamReader(System.in);
            BufferedReader bfr = new BufferedReader(rd);

            System.out.print("Podaj Login: ");
            String login = bfr.readLine();
            System.out.print("Podaj Hasło: ");
            String haslo = bfr.readLine();

            boolean logState = log.check(login, haslo);


            if(logState){
                System.out.print("OK!");
            }
            else{
                System.out.print("Hasło niepoprawne: ");
            }


        }catch(IOException e){e.printStackTrace();}

    }
}
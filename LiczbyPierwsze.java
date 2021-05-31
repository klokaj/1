import java.util.*;

public class LiczbyPierwsze {

    public List getPrimes(int _number){
        List primes = new Vector();


        for(int i = 2; i < _number; i++){
            boolean prim = true;

            Enumeration e = ((Vector) primes).elements();

            while(e.hasMoreElements()) {
                if (i % (int) e.nextElement() != 0) {
                    continue;
                } else {
                    if ((int) e.nextElement() == 1) {
                        continue;
                    }
                    prim = false;
                    break;
                }
            }

            if(prim == true){
                primes.add(i);
            }

        }
        return primes;
    }
}

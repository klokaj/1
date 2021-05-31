import java.io.*;
import java.util.*;

public class LiczbyPierwszeProgram {
    public static void main(String[] argv){
        LiczbyPierwsze lp = new LiczbyPierwsze();
        List primes = new Vector(lp.getPrimes(1000));
        System.out.print(primes);

    }
}

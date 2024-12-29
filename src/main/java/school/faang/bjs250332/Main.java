package school.faang.bjs250332;

import java.math.BigInteger;

public class Main {

    public static void main(String[] args) {
        final long start = System.currentTimeMillis();
        System.out.println("main started");
        BigInteger result = Factorial.factorialBig(21);
        System.out.println(result);
        System.out.println("main ended");
        long end = System.currentTimeMillis();
        System.out.println("time elapsed: " + (end - start));
    }

}

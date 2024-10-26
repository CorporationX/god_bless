package school.faang.greatandterriblefactorial;

import java.math.BigInteger;

public class Factorial {
    protected static final int MAX_INT_FACTORIAL = 12;
    protected static final int MAX_LONG_FACTORIAL = 19;

    public static int factorialInt(int n) throws IllegalArgumentException {
        if (n < 0 || n > MAX_INT_FACTORIAL) {
            throw new IllegalArgumentException("Value out of range for int factorial calculation.");
        }
        int result = 1;
        for (int i = 2; i <= n; i++) {
            result *= i;
        }
        return result;
    }

    public static long factorialLong(int n) throws IllegalArgumentException {
        if (n <= MAX_INT_FACTORIAL) {
            return factorialInt(n);
        }
        if (n > MAX_LONG_FACTORIAL) {
            throw new IllegalArgumentException("Value out of range for long factorial calculation.");
        }
        long result = 1L;
        for (int i = 2; i <= n; i++) {
            result *= i;
        }
        return result;
    }

    public static BigInteger factorialBig(int n) {
        if (n <= MAX_LONG_FACTORIAL) {
            return BigInteger.valueOf(factorialLong(n));
        }
        BigInteger result = BigInteger.ONE;
        for (int i = 2; i <= n; i++) {
            result = result.multiply(BigInteger.valueOf(i));
        }
        return result;
    }
}
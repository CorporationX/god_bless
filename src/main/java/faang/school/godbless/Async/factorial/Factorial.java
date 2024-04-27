package faang.school.godbless.Async.factorial;

import java.math.BigInteger;

public class Factorial {
    private static final int MAX_INT_FACTORIAL = 12;
    private static final int MAX_LONG_FACTORIAL = 19;

    static int factorialInt(int n) throws IllegalArgumentException {
        int length = String.valueOf(n).length();
        if (length > 0 && length <= MAX_INT_FACTORIAL) {
            return calculate(n).intValue();
        } else {
            throw new IllegalArgumentException();
        }
    }

    static long factorialLong(int n) throws IllegalArgumentException {
        int length = String.valueOf(n).length();
        if (length > MAX_INT_FACTORIAL + 1 && length <= MAX_LONG_FACTORIAL) {
            return calculate(n).longValue();
        } else {
            throw new IllegalArgumentException();
        }
    }

    static BigInteger factorialBig(int n) throws IllegalArgumentException {
        BigInteger number = BigInteger.valueOf(n);
        BigInteger length = BigInteger.valueOf(String.valueOf(number).length());
        if (length.compareTo(BigInteger.valueOf(MAX_INT_FACTORIAL + 1)) > 0 && length.compareTo(BigInteger.valueOf(MAX_LONG_FACTORIAL)) <= 0) {
            return BigInteger.valueOf(factorialLong(n));
        } else {
            return calculate(n);
        }
    }

    public static BigInteger calculate(int n) {
        if (n == 0 || n == 1) {
            return BigInteger.ONE;
        }
        BigInteger result = BigInteger.ONE;
        for (int i = 2; i <= n; i++) {
            result = result.multiply(BigInteger.valueOf(i));
        }
        return result;
    }
}

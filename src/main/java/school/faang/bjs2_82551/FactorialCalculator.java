package school.faang.bjs2_82551;

import lombok.extern.slf4j.Slf4j;

import java.math.BigInteger;
import java.util.List;
import java.util.concurrent.CompletableFuture;

@Slf4j
public class FactorialCalculator {
    public static final int MAX_INT_FACTORIAL = 12;
    public static final int MAX_LONG_FACTORIAL = 19;

    private static int factorialInt(int num) throws IllegalArgumentException {
        if (num > MAX_INT_FACTORIAL) {
            log.warn("Число {} больше допустимого значения {}", num, MAX_INT_FACTORIAL);
            throw new IllegalArgumentException("Число больше допустимого значения");
        }

        if (num == 0 || num == 1) {
            return 1;
        }

        int factorial = 1;
        for (int i = 2; i <= num; i++) {
            factorial *= i;
        }

        return factorial;
    }

    private static long factorialLong(int num) throws IllegalArgumentException {
        if (num > MAX_LONG_FACTORIAL) {
            log.warn("Число {} больше допустимого значения {}", num, MAX_LONG_FACTORIAL);
            throw new IllegalArgumentException("Число больше допустимого значения");
        }

        if (num <= MAX_INT_FACTORIAL) {
            return factorialInt(num);
        }

        int factorial = 1;
        for (int i = 2; i <= num; i++) {
            factorial *= i;
        }

        return factorial;
    }

    private static BigInteger factorialBig(int num) {
        if (num <= MAX_LONG_FACTORIAL) {
            return BigInteger.valueOf(factorialLong(num));
        }

        BigInteger factorial = BigInteger.valueOf(1);
        for (int i = 2; i <= num; i++) {
            factorial = factorial.multiply(BigInteger.valueOf(i));
        }

        return factorial;
    }

    public static List<CompletableFuture<BigInteger>> factorials(List<Integer> numbers) {
        return numbers.stream()
                .map(num -> CompletableFuture.supplyAsync(() -> factorialBig(num)))
                .toList();
    }
}

package school.faang.greatandterriblefactorial;

import java.math.BigInteger;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

public class FactorialCalculator {

    public static List<CompletableFuture<BigInteger>> calculateFactorials(List<Integer> numbers) {
        return numbers.stream()
                .map(n -> CompletableFuture.supplyAsync(() -> {
                    if (n <= Factorial.MAX_INT_FACTORIAL) {
                        return BigInteger.valueOf(Factorial.factorialInt(n));
                    } else if (n <= Factorial.MAX_LONG_FACTORIAL) {
                        return BigInteger.valueOf(Factorial.factorialLong(n));
                    } else {
                        return Factorial.factorialBig(n);
                    }
                }))
                .collect(Collectors.toList());
    }
}

package school.faang.sprint_4.task_50230;

import java.math.BigInteger;
import java.util.List;
import java.util.concurrent.CompletableFuture;

public class Factorial {
    
    public static BigInteger calculateFactorial(int n) {
        BigInteger bigInteger = new BigInteger("1");
        for (int i = 1; i <= n; i++) {
            bigInteger = bigInteger.multiply(BigInteger.valueOf(i));
        }
        return bigInteger;
    }

    public static List<CompletableFuture<BigInteger>> calculateFactorials(List<Integer> numbers) {
        return numbers.stream()
                .map(n -> CompletableFuture.supplyAsync(() -> calculateFactorial(n)))
                .toList();
    }
}

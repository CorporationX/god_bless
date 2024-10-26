package bjs2_37877;

import java.math.BigInteger;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.atomic.AtomicInteger;

public class Main {

    public static void main(String[] args) {
        List<Integer> numbers = List.of(5, 1, 0, 11, 17, 15, 16, 20, 23);

        List<CompletableFuture<BigInteger>> factorials = Factorial.factorials(numbers);
        CompletableFuture.allOf(factorials.toArray(new CompletableFuture[0]));

        AtomicInteger counter = new AtomicInteger(0);
        List<CompletableFuture<Void>> printFactorialCalculationResult = factorials.stream()
                .map(factorial -> factorial.thenAccept(res -> {
                    counter.getAndIncrement();
                    System.out.printf("Factorial: %d\n", res);
                })).toList();
        CompletableFuture.allOf(printFactorialCalculationResult.toArray(new CompletableFuture[0]));

        System.out.println(counter);
        Factorial.EXECUTOR_SERVICE.shutdown();
    }
}

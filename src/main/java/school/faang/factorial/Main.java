package school.faang.factorial;

import java.math.BigInteger;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.atomic.AtomicInteger;

public class Main {
    public static void main(String[] args) {
        Factorial factorial = new Factorial();
        List<Integer> integers = List.of(0, 1, 2, 3, 4, 5, 6);

        List<CompletableFuture<BigInteger>> futures;
        futures = factorial.factorials(integers);

        AtomicInteger atomicInteger = new AtomicInteger(0);
        for (CompletableFuture<BigInteger> future : futures) {
            CompletableFuture.supplyAsync(future::join)
                    .thenCompose(bigInteger ->
                            CompletableFuture.runAsync(() -> {
                                System.out.println(bigInteger);
                                atomicInteger.incrementAndGet();
                            }));
        }

        while (true) {
            if (atomicInteger.get() == integers.size()) {
                break;
            }
        }
    }
}
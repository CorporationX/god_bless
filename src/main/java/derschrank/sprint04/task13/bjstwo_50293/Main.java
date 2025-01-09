package derschrank.sprint04.task13.bjstwo_50293;

import java.math.BigInteger;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

public class Main {
    private static final int MAX_NUMBER = 20;
    private static final int SIZE_OF_THREAD_POOL = 10;

    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(SIZE_OF_THREAD_POOL);

        List<Integer> numbers = IntStream.rangeClosed(0, MAX_NUMBER).boxed().toList();
        List<CompletableFuture<BigInteger>> futures = Factorial.factorials(numbers, executor);

        CompletableFuture.allOf(futures.toArray(CompletableFuture[]::new)).join();
        executor.shutdown();

        for (int i = 0; i < numbers.size(); i++) {
            System.out.printf("Factorial for %d is %s%n", numbers.get(i), futures.get(i).join());
        }
    }
}

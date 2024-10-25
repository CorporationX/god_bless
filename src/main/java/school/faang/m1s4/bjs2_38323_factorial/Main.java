package school.faang.m1s4.bjs2_38323_factorial;

import lombok.extern.slf4j.Slf4j;

import java.math.BigInteger;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Slf4j
public class Main {
    private static final int N_NUMBERS = 15_000;
    private static final int MAX_NUMBER = 10_000;

    public static void main(String[] args) {
        Random random = new Random();
        ExecutorService service = Executors.newFixedThreadPool(10);
        Factorial factorial = new Factorial();
        List<Integer> numbers = new ArrayList<>();

        for (int i = 0; i < N_NUMBERS; i++) {
            numbers.add(random.nextInt(MAX_NUMBER));
        }

        System.out.printf("%s: Speed experiment #1 --- For cycle, brute force%n", LocalTime.now());
        List<BigInteger> resultBruteForce = new ArrayList<>();
        long startForCycle = System.currentTimeMillis();
        numbers.forEach(number -> resultBruteForce.add(factorial.factorial(number)));
        System.out.printf("Time spent: %d ms%n", System.currentTimeMillis() - startForCycle);

        System.out.println("-------------------------");

        System.out.printf("%s: Speed experiment #2 --- Multithreading%n", LocalTime.now());
        List<BigInteger> resultMultithreading = new ArrayList<>();
        long startMultithreading = System.currentTimeMillis();
        List<CompletableFuture<BigInteger>> tasksMultithreading = factorial.factorials(numbers, service);
        CompletableFuture.allOf(tasksMultithreading.toArray(new CompletableFuture[0]))
                .thenRunAsync(() ->
                        tasksMultithreading.forEach(task -> {
                                    synchronized (resultMultithreading) {
                                        resultMultithreading.add(task.join());
                                    }
                                }
                        ))
                .join();
        System.out.printf("Time spent: %d ms%n", System.currentTimeMillis() - startMultithreading);

        System.out.println("-------------------------");

        System.out.printf("%s: Speed experiment #3 --- Multithreading Optimized%n", LocalTime.now());
        List<BigInteger> resultMultithreadingOptimized = new ArrayList<>();
        long startMultithreadingOptimus = System.currentTimeMillis();
        List<CompletableFuture<BigInteger>> tasksMultithreadingOptimized = factorial.factorialsOptimyzed(numbers, service);
        CompletableFuture.allOf(tasksMultithreadingOptimized.toArray(new CompletableFuture[0]))
                .thenRunAsync(() ->
                        tasksMultithreading.forEach(task -> {
                                    synchronized (resultMultithreadingOptimized) {
                                        resultMultithreadingOptimized.add(task.join());
                                    }
                                }
                        ))
                .join();
        System.out.printf("Time spent: %d ms%n", System.currentTimeMillis() - startMultithreadingOptimus);

        service.shutdown();
        try {
            if (!service.awaitTermination(5, TimeUnit.MINUTES)) {
                service.shutdownNow();
            }
        } catch (InterruptedException e) {
            log.error("Thread has been terminated", e);
        }
    }
}

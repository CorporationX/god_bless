package faang.school.godbless.factorial;

import java.math.BigInteger;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicLong;

public class Main {

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        List<Integer> numbers = List.of(6, 50, 100, 200, 300, 400, 10, 25, 10000);

        List<CompletableFuture<BigInteger>> result = Factorial.factorials(numbers, executorService);
        AtomicLong counter = new AtomicLong(0);
        for (int i = 0; i < result.size(); i++) {
            int finalI = i;
            executorService.execute(() -> {
                System.out.println(String.format("Factorial of %d - %d", numbers.get(finalI), getFromFuture(result.get(finalI))));
                counter.incrementAndGet();
            });
        }
        int awaitCounter = 0;
        while (counter.get() != numbers.size()) {
            awaitCounter++;
        }

        executorService.shutdown();
        awaitTermination(executorService, 5);
        System.out.println("Awaited all asynchronous tasks, counter = " + awaitCounter);
    }

    private static <T> T getFromFuture(Future<T> future) {
        try {
            return future.get(30L, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new RuntimeException(e);
        } catch (ExecutionException | TimeoutException e) {
            throw new RuntimeException(e);
        }
    }

    private static void awaitTermination(ExecutorService executorService, int minutes) {
        try {
            executorService.awaitTermination(minutes, TimeUnit.MINUTES);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}

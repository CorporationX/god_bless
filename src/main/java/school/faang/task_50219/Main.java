package school.faang.task_50219;

import java.math.BigInteger;
import java.util.List;
import java.util.concurrent.*;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        List<Integer> numbers = List.of(50, 100, 200, 300, 400, 10, 25, 10000);
        List<CompletableFuture<BigInteger>> results = Factorial.factorials(numbers, executorService);

        results.forEach(result -> {
            try {
                BigInteger get = result.get();
                System.out.println("Result : " + get);
            } catch (InterruptedException | ExecutionException e) {
                throw new RuntimeException(e);
            }
        });

        if (!executorService.awaitTermination(30, TimeUnit.SECONDS)) {
            executorService.shutdown();
        }
    }
}
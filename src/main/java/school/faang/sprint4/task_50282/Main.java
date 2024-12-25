package school.faang.sprint4.task_50282;

import java.math.BigInteger;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        List<Integer> numbers = List.of(50, 100, 200, 300, 400, 10, 25, 10000);

        List<CompletableFuture<BigInteger>> future = Factorial.factorials(numbers);

        int taskCount = numbers.size();
        CountDownLatch latch = new CountDownLatch(taskCount);

        IntStream.range(0, taskCount)
                .forEach((i) -> {
                    new Thread(() -> {
                        try {
                            BigInteger result = future.get(i).get();
                            System.out.println("Factorial for n = " + numbers.get(i) + " : " + result);
                            latch.countDown();
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        } catch (ExecutionException e) {
                            throw new RuntimeException(e);
                        }
                    }).start();
                });

        try {
            latch.await();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("All computations are completed");
    }
}

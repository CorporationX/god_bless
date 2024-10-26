package school.faang.factorial;

import lombok.extern.slf4j.Slf4j;

import java.math.BigInteger;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

@Slf4j
public class Main {
    private static final int NUM_OF_THREADS = 8;
    private static final ExecutorService executor = Executors.newFixedThreadPool(NUM_OF_THREADS);

    public static void main(String[] args) {
        List<Integer> numbers = IntStream.rangeClosed(1, 25)
                .boxed()
                .toList();
        AtomicInteger tasksCompleted = new AtomicInteger(0);
        List<CompletableFuture<BigInteger>> futuresCalculate = Factorial.factorials(numbers);
        List<CompletableFuture<BigInteger>> futuresTrack = futuresCalculate.stream()
                .map(future -> future.whenCompleteAsync(
                        (bigInt, ex) -> {
                            if (ex != null) {
                                log.error(ex.getMessage(), ex);
                            } else {
                                System.out.println(bigInt);
                                System.out.println("На текущий момент выполнено " + tasksCompleted.incrementAndGet() + " задач");
                            }
                        },
                        executor))
                .toList();

        CompletableFuture.allOf(futuresTrack.toArray(new CompletableFuture[0]))
                .whenComplete((res, ex) -> {
                    executor.shutdown();
                    System.out.println("Все задачи были завершены: " + tasksCompleted.get());
                })
                .join();
    }
}

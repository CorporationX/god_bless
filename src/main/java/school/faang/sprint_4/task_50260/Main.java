package school.faang.sprint_4.task_50260;

import lombok.extern.slf4j.Slf4j;

import java.math.BigInteger;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

@Slf4j
public class Main {
    public static final int THREADS_SIZE = 2;
    public static final int TIMEOUT = 60;

    public static void main(String[] args) {
        List<Integer> numbers = List.of(11, 12, 13, 18, 19, 20, 25);
        List<CompletableFuture<BigInteger>> futureList = Factorial.factorials(numbers);
        AtomicInteger counter = new AtomicInteger(0);
        ExecutorService executor = Executors.newFixedThreadPool(THREADS_SIZE);

        for (int i = 0; i < numbers.size(); i++) {
            int index = i;
            CompletableFuture.runAsync(() -> {
                BigInteger factorial = futureList.get(index).join();
                log.info("Факториал числа {} это {}", numbers.get(index), factorial);
                counter.incrementAndGet();
            }, executor);
        }


        executor.shutdown();
        try {
            if (!executor.awaitTermination(TIMEOUT, TimeUnit.SECONDS)) {
                log.error("Задачи не завершились в течение заданного времени.");
            }
            log.info("Все асинхронные задачи завершены. Итераций ожидания: {}", counter.get());
        } catch (InterruptedException e) {
            log.error("Поток прерван во время ожидания завершения задач", e);
            Thread.currentThread().interrupt();
        }

    }
}

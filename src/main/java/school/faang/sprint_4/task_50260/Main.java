package school.faang.sprint_4.task_50260;

import lombok.extern.slf4j.Slf4j;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

@Slf4j
public class Main {
    private static final int THREADS_SIZE = Runtime.getRuntime().availableProcessors();
    private static final int TIMEOUT = 60;

    public static void main(String[] args) {
        List<Integer> numbers = List.of(11, 12, 13, 18, 19, 20, 25);
        List<CompletableFuture<BigInteger>> futureList = Factorial.factorials(numbers);
        AtomicInteger counter = new AtomicInteger(0);
        List<CompletableFuture<Void>> futures = new ArrayList<>();

        log.info("Количество доступных процессоров при расчете факториалов: {}", THREADS_SIZE);
        ExecutorService executor = Executors.newFixedThreadPool(THREADS_SIZE);

        for (int i = 0; i < numbers.size(); i++) {
            int index = i;
            CompletableFuture<Void> future = CompletableFuture.supplyAsync(() -> {
                try {
                    return futureList.get(index).join();
                } catch (CompletionException e) {
                    log.error("Ошибка при вычислении факториала числа {}: {}", numbers.get(index), e.getMessage());
                    return null;
                }
            }, executor).thenAccept(factorial -> {
                log.info("Факториал числа {} это {}", numbers.get(index), factorial);
                counter.incrementAndGet();
            });
            futures.add(future);
        }

        CompletableFuture.allOf(futures.toArray(new CompletableFuture[0]))
                .whenComplete((result, throwable) -> {
                    if (throwable == null) {
                        log.info("Все асинхронные задачи завершены. Итераций ожидания: {}", counter.get());
                        executor.shutdown();
                    } else {
                        log.error("Возникла ошибка при выполнении задач: {}", throwable.getMessage());
                    }
                }).join();
    }
}

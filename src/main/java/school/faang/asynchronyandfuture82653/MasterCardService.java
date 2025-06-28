package school.faang.asynchronyandfuture82653;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;


@Slf4j
public class MasterCardService {
    private static final int TEN_SECONDS_IN_MS = 10_000;
    private static final int ONE_SECOND_IN_MS = 1_000;
    private static final int NUMBER_OF_THREADS = 2;

    private void collectPayment() {
        try {
            Thread.sleep(TEN_SECONDS_IN_MS);
            System.out.println("Оплата прошла");
        } catch (InterruptedException e) {
            throw new IllegalStateException("Поток был прерван", e);
        }
    }

    private void sendAnalytics() {
        try {
            Thread.sleep(ONE_SECOND_IN_MS);
            System.out.println("Анализ отправлен");
        } catch (InterruptedException e) {
            throw new IllegalStateException("Поток был прерван", e);
        }
    }

    public void doAll() throws ExecutionException, InterruptedException {
        ExecutorService executor = Executors.newFixedThreadPool(NUMBER_OF_THREADS);
        try {
            Future<?> future1 = executor.submit(this::collectPayment);

            CompletableFuture<Void> future2 = CompletableFuture.runAsync(this::sendAnalytics, executor);

            future2.get();
            future1.get();
        } finally {
            executor.shutdown();
        }
    }
}

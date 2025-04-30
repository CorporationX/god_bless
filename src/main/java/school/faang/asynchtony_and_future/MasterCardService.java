package school.faang.asynchtony_and_future;

import lombok.extern.slf4j.Slf4j;

import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;


@Slf4j
public class MasterCardService {
    private static final int THREAD_SLEEP_PAYMENT = 10000;
    private static final int THREAD_SLEEP_ANALYTICS = 1000;
    private static final Random RANDOM = new Random();

    public int collectPayment() {
        log.info("Произвожу оплату");
        try {
            Thread.sleep(THREAD_SLEEP_PAYMENT);
            return RANDOM.nextInt();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new RuntimeException("Error");
        } finally {
            log.info("Оплата прошла успешно");
        }
    }

    public int sendAnalytics() {
        log.info("Отправляю данные");
        try {
            Thread.sleep(THREAD_SLEEP_ANALYTICS);
            return RANDOM.nextInt();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new RuntimeException("Error");
        } finally {
            log.info("Данные отправлены успешно");
        }

    }

    public void doAll() throws ExecutionException, InterruptedException {
        final int threadPool = 2;
        ExecutorService service = Executors.newFixedThreadPool(threadPool);
        Future<Integer> future = service.submit(this::collectPayment);
        CompletableFuture<Integer> completableFuture = CompletableFuture.supplyAsync(this::sendAnalytics, service);

        int resultFuture = 0;
        while (!future.isDone() && !completableFuture.isDone()) {
            completableFuture.join();
            resultFuture = future.get();
            log.info("Ждем ответа");
            Thread.sleep(THREAD_SLEEP_ANALYTICS);
        }

        log.info("{} and {}", resultFuture, completableFuture.get());
        service.shutdown();
    }
}
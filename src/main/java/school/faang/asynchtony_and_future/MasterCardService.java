package school.faang.asynchtony_and_future;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.*;

@Slf4j
public class MasterCardService {
    public int collectPayment() {
        log.info("Произвожу оплату");
        try {
            Thread.sleep(10000);
            return 15;
        } catch (InterruptedException e) {
            throw new RuntimeException("Error");
        } finally {
            log.info("Оплата прошла успешно");
        }
    }

    public int sendAnalytics() {
        log.info("Отправляю данные");
        try {
            Thread.sleep(1000);
            return 17;
        } catch (InterruptedException e) {
            throw new RuntimeException("Error");
        } finally {
            log.info("Данные отправлены успешно");
        }

    }

    public void doAll() throws ExecutionException, InterruptedException {
        ExecutorService service = Executors.newFixedThreadPool(2);
        Future<Integer> future = service.submit(this::collectPayment);
        CompletableFuture<Integer> completableFuture = CompletableFuture.supplyAsync(this::sendAnalytics);

        while (!future.isDone() && !completableFuture.isDone()) {
            log.info("Ждем ответа");
            Thread.sleep(1000);
        }

        log.info("{} and {}", future.get(), completableFuture.get());
        service.shutdown();
    }
}
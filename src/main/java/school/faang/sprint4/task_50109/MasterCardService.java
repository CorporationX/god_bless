package school.faang.sprint4.task_50109;

import lombok.extern.slf4j.Slf4j;
import java.util.concurrent.*;

@Slf4j
public class MasterCardService {

    static ExecutorService threadPool = Executors.newFixedThreadPool(4);

    static int collectPayment() {
        try {
            Thread.sleep(3_000);
            return 3_000;
        } catch (InterruptedException e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
    }

    static int sendAnalytics() {
        try {
            Thread.sleep(1_000);
            return 1_000;
        } catch (InterruptedException e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
    }

    static void doAll() {
        // collect payment
        Future<Integer> futurePayment = threadPool.submit(MasterCardService::collectPayment);
        // send analytics
        CompletableFuture<Integer> futureAnalytics = CompletableFuture.supplyAsync(
                MasterCardService::sendAnalytics,
                threadPool
        );
        futureAnalytics.thenAccept((analyticsSeconds) -> {
            System.out.println("аналитика отправлена : " + analyticsSeconds);
        }).join();
        try {
            Integer paymentSeconds = futurePayment.get();
            System.out.println("платеж отправлен : " + paymentSeconds);
        } catch (InterruptedException | ExecutionException e) {
            log.error(e.getMessage());
        }
        threadPool.shutdown();
    }
}


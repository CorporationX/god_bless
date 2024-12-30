package school.faang.task_49954;

import lombok.SneakyThrows;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class MasterCardService {
    @SneakyThrows
    public static int collectPayment() {
        Thread.sleep(1050);
        return 10000;
    }

    @SneakyThrows
    public static int sendAnalytics() {
        Thread.sleep(1000);
        return 1000;
    }

    @SneakyThrows
    public void doAll() {
        ExecutorService executorService = Executors.newSingleThreadExecutor();

        Future<Integer> paymentFuture = executorService.submit(MasterCardService::collectPayment);

        CompletableFuture<Integer> analyticsFuture = CompletableFuture
                .supplyAsync(MasterCardService::sendAnalytics);

        Integer analyticResults = analyticsFuture.join();
        System.out.println("Analytics sent: " + analyticResults);

        while (!paymentFuture.isDone()) {
            System.out.println("Payment is in progress..");
        }

        Integer paymentResults = paymentFuture.get();
        System.out.println("Payment completed: " + paymentResults);

        executorService.shutdown();
    }
}
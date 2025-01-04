package school.faang.AsyncFuture_43570;

import lombok.SneakyThrows;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class MasterCardService {
    public static int collectPayment() {
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
        return 10000;
    }

    public static int sendAnalytics() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
        return 1000;
    }

    @SneakyThrows
    public void doAll() {
        ExecutorService service = Executors.newFixedThreadPool(1);
        Future<Integer> analyticsFuture = service.submit(MasterCardService::sendAnalytics);
        Integer analyticsResult = analyticsFuture.get();
        System.out.println("Аналитика: " + analyticsResult);
        CompletableFuture<Integer> collectFuture = CompletableFuture
                .supplyAsync(MasterCardService::collectPayment);
        Integer collectResult = collectFuture.join();
        System.out.println("Платеж: " + analyticsResult);
    }
}

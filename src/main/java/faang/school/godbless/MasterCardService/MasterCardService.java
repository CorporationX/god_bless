package faang.school.godbless.MasterCardService;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MasterCardService {
    private ExecutorService executorService = Executors.newSingleThreadExecutor();


    public static void main(String[] args) {
        MasterCardService masterCardService = new MasterCardService();
        masterCardService.doAll();
    }

    public void doAll() {
        CompletableFuture<Integer> futureCollectPayment = CompletableFuture.supplyAsync(MasterCardService::collectPayment, executorService);

        CompletableFuture<Integer> futureSendAnalytics = CompletableFuture.supplyAsync(MasterCardService::sendAnalytics, executorService);

        futureSendAnalytics.thenAccept(result -> System.out.println("sendAnalytics result: " + result)).join();

        futureCollectPayment.thenAccept(result -> System.out.println("collectPayment result: " + result)).join();
    }

    static int collectPayment() {
        try {
            Thread.sleep(10_000);
            return 10_000;
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
}

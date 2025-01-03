package derschrank.sprint04.task01.bjstwo_49942;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class MasterCardService implements CardServiceInterface {
    private final ExecutorService executor;

    public MasterCardService() {
        executor = Executors.newSingleThreadExecutor();
    }

    @Override
    public void doAll() throws Exception {
        Future<Integer> collectPaymentFuture = executor.submit(this::collectPayment);
        CompletableFuture<Integer> sendAnalyticsFuture = CompletableFuture.supplyAsync(this::sendAnalytics);

        Integer analyticsResult = sendAnalyticsFuture.join();
        System.out.println("Аналитика отправлена: " + analyticsResult);

        Integer paymentResult = collectPaymentFuture.get();
        System.out.println("Платеж выполнен: " + paymentResult);

        executor.shutdown();
    }

    @Override
    public int collectPayment() {
        try {
            Thread.sleep(10_000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return 10_000;
    }

    @Override
    public int sendAnalytics() {
        try {
            Thread.sleep(1_000);

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return 1_000;
    }
}

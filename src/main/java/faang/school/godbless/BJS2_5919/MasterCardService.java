package faang.school.godbless.BJS2_5919;

import java.util.concurrent.*;

public class MasterCardService {
    public int collectPayment() {
        try {
            Thread.sleep(10_000);
            return 10_000;
        } catch (InterruptedException e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
    }

    public int sendAnalytics() {
        try {
            Thread.sleep(1_000);
            return 1_000;
        } catch (InterruptedException e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
    }

    public void doAll() {
        ExecutorService executor = Executors.newFixedThreadPool(2);

        Future<Integer> collectPaymentFuture = executor.submit(this::collectPayment);
        CompletableFuture<Integer> sendAnalyticsFuture = CompletableFuture.supplyAsync(this::sendAnalytics, executor);

        try {
            int infFromSendAnalytics = sendAnalyticsFuture.get();
            System.out.println("Результат мз infFromSendAnalytics:" + infFromSendAnalytics);
        } catch (InterruptedException | ExecutionException e) {
            throw new RuntimeException(e);
        }

        try {
            int infFromCollectPayment = collectPaymentFuture.get();
            System.out.println("Результат мз infFromCollectPayment:" + infFromCollectPayment);
        } catch (InterruptedException | ExecutionException e) {
            throw new RuntimeException(e);
        }

        executor.shutdown();

        try {
            if (!executor.awaitTermination(10, TimeUnit.SECONDS)) {
                System.out.println("Не все задачи завершились за отведенное время");
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
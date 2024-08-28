package faang.school.godbless.BJS2_24695;

import java.util.concurrent.*;

public class MasterCardService {

    private int collectPayment() {
        try {
            Thread.sleep(10_000);
            return 10_000;
        } catch (InterruptedException e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
    }

    private int sendAnalytics() {
        try {
            Thread.sleep(1_000);
            return 1_000;
        } catch (InterruptedException e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
    }

    public void doAll() {
        ExecutorService executorService = Executors.newFixedThreadPool(2);

        Future<Integer> collectPaymentResult = executorService.submit(this::collectPayment);
        CompletableFuture<Integer> sendAnalyticsResult = CompletableFuture.supplyAsync(this::sendAnalytics, executorService);
        try {
            System.out.printf("Результат выполнения метода sendAnalytics: %d.%n",
                    sendAnalyticsResult.get(2, TimeUnit.SECONDS));
            System.out.printf("Результат выполнения метода collectPayment: %d.%n",
                    collectPaymentResult.get(12, TimeUnit.SECONDS));

            executorService.shutdown();
            System.out.println(
                    executorService.awaitTermination(1, TimeUnit.SECONDS)
                            ? "Все задания выполнены" : "Выполнение было прервано"
            );
        } catch (InterruptedException | ExecutionException | TimeoutException e) {
            throw new RuntimeException(e);
        }
    }
}

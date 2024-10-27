package school.faang.asyncandfuture;

import java.util.concurrent.*;

public class MasterCardService {
    public static int collectPayment() {
        try {
            Thread.sleep(10_000);
            return 10_000;
        } catch (InterruptedException e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
    }

    public static int sendAnalytics() {
        try {
            Thread.sleep(1_000);
            return 1_000;
        } catch (InterruptedException e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
    }

    public void doAll() throws ExecutionException, InterruptedException {
        ExecutorService executor = Executors.newFixedThreadPool(1);
        Future<Integer> futurePayment =
            executor.submit(MasterCardService::collectPayment);
        executor.shutdown();
        executor.close();

        CompletableFuture<Integer> futureAnalytics =
            CompletableFuture.supplyAsync(MasterCardService::sendAnalytics);

        while (!futureAnalytics.isDone()) {
            continue;
        }
        System.out.println("Аналитика отправлена: " + futureAnalytics.get());

        while (!futurePayment.isDone()) {
            continue;
        }
        System.out.println("Платеж выполнен: " + futurePayment.get());
    }

}

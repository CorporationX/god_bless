package school.faang.asynh_and_future.main_code;

import java.util.concurrent.*;

public class MasterCardService {
    private static int collectPayment() {
        try {
            Thread.sleep(10_000);
            return 10_000;
        } catch (InterruptedException e) {
            e.printStackTrace();
            throw new RuntimeException("Ошибка попытки платежа " + e);
        }
    }

    private static int sendAnalytics() {
        try {
            Thread.sleep(1_000);
            return 1_000;
        } catch (InterruptedException e) {
            e.printStackTrace();
            throw new RuntimeException("ошибка отправки аналитики " + e);
        }
    }

    public static void doAll() {
        ExecutorService service = Executors.newSingleThreadExecutor();

        Future<Integer> analiticsFuture = service.submit(MasterCardService::collectPayment);

        CompletableFuture<Integer> paymentsCompletableFuture =
                CompletableFuture.supplyAsync(MasterCardService::sendAnalytics);

        int analiticsResult = paymentsCompletableFuture.join();
        System.out.println("Аналитика отправлена " + analiticsResult);

        try {
            int paymentsResult = analiticsFuture.get();
            System.out.println("Платеж выполнен " + paymentsResult);
        } catch (InterruptedException | ExecutionException e) {
            throw new RuntimeException("Возникла ошибка при попытке платежа " + e);
        }

        service.shutdown();

        try {
            if (!service.awaitTermination(2, TimeUnit.MINUTES)) {
                service.shutdownNow();
            }
        } catch (InterruptedException e) {
            System.out.println("Ошибка при попытке завершения программы" + e);
            e.printStackTrace();
            service.shutdownNow();
        }
    }
}

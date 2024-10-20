package school.faang.asynh_and_future.main_code;

import java.util.concurrent.*;

public class MasterCardService {
    private static int collectPayment() {
        try {
            Thread.sleep(10_000);
            return 10_000;
        } catch (InterruptedException e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
    }

    private static int sendAnalytics() {
        try {
            Thread.sleep(1_000);
            return 1_000;
        } catch (InterruptedException e) {
            e.printStackTrace();
            throw new RuntimeException();
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
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } catch (ExecutionException e) {
            throw new RuntimeException(e);
        }

        service.shutdown();

        try {
            if (!service.awaitTermination(2, TimeUnit.MINUTES)) {
                service.shutdownNow();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
            service.shutdownNow();
        }
    }
}

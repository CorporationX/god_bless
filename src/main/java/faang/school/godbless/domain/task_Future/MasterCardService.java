package faang.school.godbless.domain.task_Future;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

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

    public void doAll() throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newSingleThreadExecutor();

        Future<Integer> paymentFuture = executorService.submit(this::collectPayment);
        CompletableFuture<Integer> analyticsFuture = CompletableFuture.supplyAsync(this::sendAnalytics);

        System.out.println("Ожидание завершения аналитики");
        int analyticsResult = analyticsFuture.get();
        System.out.println("Результат отправки аналитики " + analyticsResult);

        System.out.println("Ожидание завершения платежа");
        int paymentResult = paymentFuture.get();
        System.out.println("Заверешение сбора платежа " + paymentResult);


        executorService.shutdown();
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        MasterCardService masterCardService = new MasterCardService();
        masterCardService.doAll();
    }
}

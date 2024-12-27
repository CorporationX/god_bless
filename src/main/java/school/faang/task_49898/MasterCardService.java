package school.faang.task_49898;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class MasterCardService {
    static final int PAYMENT_DELAY = 10000;
    static final int ANALYSIS_DELAY = 1000;
    static final int PAYMENT_RESULT = 10000;
    static final int ANALYSIS_RESULT = 1000;

    static int collectPayment() {
        try {

            Thread.sleep(PAYMENT_DELAY);
            return PAYMENT_RESULT ;
        } catch (InterruptedException e) {
            e.printStackTrace();
            Thread.currentThread().interrupt();
            return 0;
        }
    }

    static int sendAnalytics() {
        try {
            Thread.sleep(ANALYSIS_DELAY);
            return ANALYSIS_RESULT;
        } catch (InterruptedException e) {
            e.printStackTrace();
            Thread.currentThread().interrupt();
            return 0;
        }
    }

    public void doAll() {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        Future<Integer> future1 = executorService.submit(MasterCardService::collectPayment);

        CompletableFuture<Integer> future2 = CompletableFuture.supplyAsync(MasterCardService::sendAnalytics);

        Integer future2Result = future2.join();
        System.out.println("Аналитика отправлена: " + future2Result);

        Integer future1Result = null;
        try {
            future1Result = future1.get();
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
            Thread.currentThread().interrupt();
        }
        System.out.println("Платеж выполнен: " + future1Result);

        executorService.shutdown();
    }
}

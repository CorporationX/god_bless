package school.faang.task_49898;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class MasterCardService {
    static int collectPayment() {
        try {
            Thread.sleep(10_000);
            return 10_000;
        } catch (InterruptedException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    static int sendAnalytics() {
        try {
            Thread.sleep(1_000);
            return 1_000;
        } catch (InterruptedException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    public void doAll() throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        Future<Integer> future1 = executorService.submit(MasterCardService::collectPayment);

        CompletableFuture<Integer> future2 = CompletableFuture.supplyAsync(MasterCardService::sendAnalytics);

        Integer future2Result = future2.join();
        System.out.println("Аналитика отправлена: " + future2Result);

        Integer future1Result = future1.get();
        System.out.println("Платеж выполнен: " + future1Result);

        executorService.shutdown();
    }
}

package async;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class MasterCardService {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        doAll(executorService);
        executorService.shutdown();
        try {
            if (!executorService.awaitTermination(800, TimeUnit.MILLISECONDS)) {
                executorService.shutdownNow();
            }
        } catch (InterruptedException e) {
            executorService.shutdownNow();
        }
    }

    public static void doAll(ExecutorService executorService) throws ExecutionException, InterruptedException {
        Future<Integer> result1 = executorService.submit(() -> collectPayment());
        Future<Integer> result2 = executorService.submit(() -> sendAnalytics());
        int r2 = result2.get();
        int r1 = result1.get();
        System.out.println(r2 + " : " + r1);
    }

    public static int collectPayment() {
    try {
        Thread.sleep(10_000);
        return 1_000;
    } catch (InterruptedException e) {
        e.printStackTrace();
        throw new RuntimeException(e);
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
}

package async_and_future;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class MasterCardService {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        doAll();
    }

    private static int collectPayment() {
        try {
            Thread.sleep(10_000);
            return 10_000;
        } catch (InterruptedException e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
    }

    private static int sendAnalystics() {
        try {
            Thread.sleep(1_000);
            return 1_000;
        } catch (InterruptedException e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
    }

    private static void doAll() throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        Future<Integer> paymentFuture =
                executorService.submit(MasterCardService::collectPayment);

        CompletableFuture<Integer> analysticsFuture =
                CompletableFuture.supplyAsync(MasterCardService::sendAnalystics);

        analysticsFuture.thenAccept(result -> {
            System.out.println("send analytics result: " + result);
        });

        System.out.println("collect payment result : " + paymentFuture.get());

        executorService.shutdown();
    }
}

package task15;

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
            throw new RuntimeException();
        }
    }

    static int sendAnalystics() {
        try {
            Thread.sleep(1_000);
            return 1_000;
        } catch (InterruptedException e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
    }

    public void doAll() throws InterruptedException, ExecutionException {
        ExecutorService executor = Executors.newFixedThreadPool(2);
        Future<Integer> resultCollectPayment = executor.submit(() -> collectPayment());
        CompletableFuture<Integer> resultSendAnalystics = CompletableFuture.supplyAsync(() -> sendAnalystics());
        System.out.println(resultSendAnalystics.join());
        while (!resultCollectPayment.isDone()) {
//            Делаем что-то другое
        }
        System.out.println(resultCollectPayment.get());
        executor.shutdown();
    }
}
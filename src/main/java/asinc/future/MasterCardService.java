package asinc.future;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class MasterCardService {

    public int collectPayment() {
        try {
            Thread.sleep(10000);
            return 10000;
        } catch (InterruptedException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    public int sendAnalytics() {
        try {
            Thread.sleep(1000);
            return 1000;
        } catch (InterruptedException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    public void doAll() throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        Future<Integer> payments = executorService.submit(this::collectPayment);
        CompletableFuture<Integer> analitics = CompletableFuture.supplyAsync(this::sendAnalytics);
        Integer resultAnalitics = analitics.join();
        System.out.println("Аналитика отправлена: " + resultAnalitics);
        Integer resultPayment = payments.get();
        System.out.println("Платеж выполнен: " + resultPayment);
    }
}

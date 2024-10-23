package school.faang.BJS238019;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class MasterCardService {
    public int collectPayment() {
        try {
            Thread.sleep(10_000);
            System.out.println("Платеж выполнен: 10000");
            return 10_000;
        } catch (InterruptedException e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
    }

    public int sendAnalytics() {
        try {
            Thread.sleep(1_000);
            System.out.println("Аналитика отправлена: 1000");
            return 1_000;
        } catch (InterruptedException e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
    }

    public void doAll() throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        Future<Integer> collectPayment =  executorService.submit(this::collectPayment);
        CompletableFuture<Integer> sendAnalytics = CompletableFuture.supplyAsync(this::sendAnalytics, executorService);
        collectPayment.get();
        sendAnalytics.get();
        executorService.shutdown();
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        MasterCardService masterCardService = new MasterCardService();
        masterCardService.doAll();;
    }
}

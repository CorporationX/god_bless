package future_1222;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Main {
    public static void main(String[] args) {

        MasterCardService masterCard = new MasterCardService();
        doAll(masterCard);
    }

    public static void doAll(MasterCardService masterCard) {

        ExecutorService service = Executors.newFixedThreadPool(1);

        Future<Integer> future = service.submit(masterCard::collectPayment);
        CompletableFuture<Integer> completableFuture = CompletableFuture.supplyAsync(masterCard::sendAnalytics);
        try {
            System.out.println("Выполнен платеж: " + future.get());
            System.out.println("Аналитика: " + completableFuture.get());
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } catch (ExecutionException e) {
            Thread.currentThread().interrupt();
            throw new RuntimeException("Выполнение операции прервано");
        }
        service.shutdown();
        System.out.println("Операции завершены");
    }
}
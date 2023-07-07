package faang.school.godbless.Sprint4Future.Task1AsynchronismAndFuture;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Main {
    MasterCardService masterCardService = new MasterCardService();

    public static void main(String[] args) {
        Main main = new Main();
        main.doAll();
    }

    public void doAll(){
        ExecutorService service = Executors.newSingleThreadExecutor();
        Future<Integer> payments = service.submit(() -> masterCardService.collectPayment());
        CompletableFuture<Integer> completableFuture = CompletableFuture
                .supplyAsync(() -> masterCardService.sendAnalytics());
        try {
            System.out.println(completableFuture.get());
            System.out.println(payments.get());
        } catch (InterruptedException | ExecutionException e) {
            throw new RuntimeException(e);
        }
        service.shutdown();
    }
}

package faang.school.godbless.async_future;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Main {

    private static MasterCardService service = new MasterCardService();

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        doAll();
    }

    public static void doAll() throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        Future<Integer> future1 = executorService.submit(() ->
                service.collectPayment());
        CompletableFuture<Integer> future2 = CompletableFuture.supplyAsync(() ->
                service.sendAnalytics());

        System.out.println(future1.get());
        System.out.println(future2.get());

        executorService.shutdown();
    }
}

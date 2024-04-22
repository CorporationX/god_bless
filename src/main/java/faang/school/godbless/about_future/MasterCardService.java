package faang.school.godbless.about_future;

import lombok.SneakyThrows;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class MasterCardService {

    public static int collectPayment() {
        try {
            Thread.sleep(10_000);
            return 10_000;
        } catch (InterruptedException e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
    }

    public static int sendAnalystics() {
        try {
            Thread.sleep(1_000);
            return 1_000;
        } catch (InterruptedException e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
    }

    @SneakyThrows
    public static void doAll() {
        ExecutorService executor = Executors.newSingleThreadExecutor();
        Future<Integer> collectFurure = executor.submit(MasterCardService::collectPayment);
        CompletableFuture<Integer> sendFuture = CompletableFuture.supplyAsync(MasterCardService::sendAnalystics);

        sendFuture.thenAcceptAsync(System.out::println);
        System.out.println(collectFurure.get());

        executor.shutdown();
        while(!executor.awaitTermination(10, TimeUnit.SECONDS)){}
    }
}

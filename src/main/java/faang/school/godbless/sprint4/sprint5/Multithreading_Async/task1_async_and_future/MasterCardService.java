package faang.school.godbless.sprint4.sprint5.Multithreading_Async.task1_async_and_future;

import lombok.SneakyThrows;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class MasterCardService {

    public static int collectPayment() {
        try {
            Thread.sleep(1_000);
            return 1_000;
        } catch (InterruptedException e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
    }

    public static int sendAnalytics() {
        try {
            Thread.sleep(10_000);
            return 10_000;
        } catch (InterruptedException e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
    }

    @SneakyThrows
    public static void doAll() {
        ExecutorService executor = Executors.newFixedThreadPool(1);
        Future<Integer> future = executor.submit(MasterCardService::collectPayment);
        CompletableFuture<Integer> integerCompletableFuture = CompletableFuture.supplyAsync(MasterCardService::sendAnalytics);
        executor.shutdown();

        System.out.println(integerCompletableFuture.get());

        System.out.println(future.get());
    }

    public static void main(String[] args) {
        doAll();
    }
}

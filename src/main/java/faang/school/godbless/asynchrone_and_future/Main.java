package faang.school.godbless.asynchrone_and_future;

import java.util.concurrent.*;

public class Main {
    private final static ExecutorService EXECUTOR_SERVICE = Executors.newFixedThreadPool(2);

    public static void main(String[] args) {
        MasterCardService masterCardService = new MasterCardService();

        doAll(masterCardService);

        System.out.println("Final");

        EXECUTOR_SERVICE.shutdown();
    }

    public static void doAll(MasterCardService masterCardService) {
        Future<Integer> future = EXECUTOR_SERVICE.submit(masterCardService::collectPayment);
        CompletableFuture<Integer> completableFuture = CompletableFuture.supplyAsync(masterCardService::sendAnalytics);

        completableFuture.thenAccept(System.out::println);

        try {
            System.out.println(future.get(60, TimeUnit.SECONDS));
        } catch (InterruptedException | ExecutionException | TimeoutException e) {
            throw new RuntimeException(e);
        }
    }
}

package faang.school.godbless.asynchronism.task1;

import java.util.concurrent.*;

public class MasterCard {
    private static final MasterCardService service = new MasterCardService();

    public static void main(String[] args) {
        doAll();
    }

    private static void doAll() {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        Future<Integer> future = executorService.submit(service::collectPayment);
        CompletableFuture<Integer> future2 = CompletableFuture.supplyAsync(service::sendAnalytics);
        try {
            System.out.println(future.get());
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
        System.out.println(future2.join());

        executorService.shutdown();
    }
}

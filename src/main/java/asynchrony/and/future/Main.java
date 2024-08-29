package asynchrony.and.future;

import java.util.concurrent.*;

public class Main {
    public static void main(String[] args) {
        MasterCardService service = new MasterCardService();
        doAll(service);
    }

    public static void doAll(MasterCardService service) {
        ExecutorService executor = Executors.newSingleThreadExecutor();

        Future<Integer> resultCollectPayment = executor.submit(service::collectPayment);
        CompletableFuture<Integer> resultSendAnalytics = CompletableFuture.supplyAsync(service::sendAnalytics);
        executor.shutdown();

        try {
            resultSendAnalytics
                    .thenAccept(result -> System.out.println("Результат выполнения sendAnalytics: " +result))
                    .join();

            while (!resultCollectPayment.isDone()) {
                System.out.println("Результат выполнения collectPayment: " + resultCollectPayment.get());
            }
        } catch (InterruptedException | ExecutionException e) {
            throw new RuntimeException(e);
        }
    }
}

package faang.school.godbless.BJS2_24790;

import lombok.NoArgsConstructor;

import java.util.concurrent.*;

@NoArgsConstructor
public class MasterCardService {
    public void doAll() {
        ExecutorService service = Executors.newSingleThreadExecutor();
        Future<Integer> collectIntegerFuture = service.submit(this::collectPayment);
        CompletableFuture<Integer> completableFuture = CompletableFuture.supplyAsync(this::sendAnalytics, service);

        try {
            int collectPaymentResult = collectIntegerFuture.get();
            System.out.println(collectPaymentResult);
            completableFuture.thenAccept(System.out::println);

            service.shutdown();
        } catch (InterruptedException | ExecutionException e) {
            throw new RuntimeException(e);
        }
    }

    private int collectPayment() {
        try {
            Thread.sleep(5_000);
            return 5_000;
        } catch (InterruptedException e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
    }

    private int sendAnalytics() {
        try {
            Thread.sleep(3_000);
            return 3_000;
        } catch (InterruptedException e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
    }
}

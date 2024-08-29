package faang.school.godbless.BJS2_24790;

import lombok.NoArgsConstructor;

import java.util.concurrent.*;

@NoArgsConstructor
public class MasterCardService {
    public void doAll() {
        ExecutorService service = Executors.newSingleThreadExecutor();
        Future<Integer> collectIntegerFuture = service.submit(this::collectPayment);
        CompletableFuture<Void> analyticsFuture = CompletableFuture.supplyAsync(this::sendAnalytics, service)
                .thenAccept(System.out::println);

        try {
            analyticsFuture.join();
            System.out.println(collectIntegerFuture.get());
            service.shutdown();
        } catch (InterruptedException | ExecutionException e) {
            throw new RuntimeException(e);
        }
    }

    private int collectPayment() {
        try {
            Thread.sleep(1_000);
            return 1_000;
        } catch (InterruptedException e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
    }

    private int sendAnalytics() {
        try {
            Thread.sleep(10_000);
            return 10_000;
        } catch (InterruptedException e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
    }
}

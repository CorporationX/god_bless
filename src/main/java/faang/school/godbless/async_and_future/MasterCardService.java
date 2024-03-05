package faang.school.godbless.async_and_future;

import lombok.Getter;
import lombok.Setter;

import java.util.concurrent.*;

@Getter
@Setter
public class MasterCardService {
    private final int payment;
    private final int analytics;

    public MasterCardService(int payment, int analytics) {
        this.payment = payment;
        this.analytics = analytics;
    }

    static int collectPayment() {
        try {
            Thread.sleep(10_000);
            return 10_000;
        } catch (InterruptedException e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
    }

    static int sendAnalytics() {
        try {
            Thread.sleep(1_000);
            return 1_000;
        } catch (InterruptedException e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
    }

    public void doAll() {
        ExecutorService executor = Executors.newSingleThreadExecutor();
        Future<Integer> paymentFuture = executor.submit(MasterCardService::collectPayment);

        CompletableFuture<Integer> analyticsFuture = CompletableFuture.supplyAsync(MasterCardService::sendAnalytics);

        CompletableFuture<Void> futuresResult = analyticsFuture
                .thenCompose(analyticsResult -> CompletableFuture.supplyAsync(() -> {
                    System.out.println("Analytics result: " + analyticsResult);
                    try {
                        System.out.println("Payment result: " + paymentFuture.get());
                    } catch (ExecutionException | InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    return null;
                }));
        futuresResult.join();
        executor.shutdown();
    }
}

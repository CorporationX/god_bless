package faang.school.godbless.async;

import lombok.RequiredArgsConstructor;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

@RequiredArgsConstructor
public class Stripe {

    private final MasterCardService masterCardService;

    public void doAll() {
        ExecutorService executorService = Executors.newSingleThreadExecutor();

        Future<Integer> paymentCollector = executorService.submit(masterCardService::collectPayment);
        CompletableFuture<Integer> analyticsSender = CompletableFuture.supplyAsync(masterCardService::sendAnalytics);

        analyticsSender
                .thenAccept(analytics -> System.out.println("analytics: " + analytics));

        try {
            var payment = paymentCollector.get(30, TimeUnit.SECONDS);
            System.out.println("payment: " + payment);
        } catch (InterruptedException | ExecutionException | TimeoutException e) {
            throw new RuntimeException(e);
        }
    }
}

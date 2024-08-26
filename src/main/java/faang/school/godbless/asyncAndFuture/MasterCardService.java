package faang.school.godbless.asyncAndFuture;

import java.util.concurrent.*;

public class MasterCardService {

    private static final int DEFAULT_ANSWER = 0;
    private static final long TIMER_ANSWER = 30_000L;

    private int collectPayment() {
        try {
            Thread.sleep(10_000L);
            return 10_000;
        } catch (InterruptedException e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
    }

    private int sendAnalytics() {
        try {
            Thread.sleep(1_000L);
            return 1_000;
        } catch (InterruptedException e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
    }

    public void doAll() throws ExecutionException, InterruptedException, TimeoutException {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        Future<Integer> payment = executorService.submit(this::collectPayment);

        CompletableFuture<Integer> analytics = CompletableFuture.supplyAsync(this::sendAnalytics);

        analytics.completeOnTimeout(DEFAULT_ANSWER, TIMER_ANSWER, TimeUnit.SECONDS)
                .thenAccept(result -> System.out.println("Sent analytics and got the result " + result));

        int resultPayment = payment.get(TIMER_ANSWER, TimeUnit.SECONDS);
        System.out.println("Collect payment result " + resultPayment);
        executorService.shutdown();
    }

}

package faang.school.godbless.spring_4.asynchrony_and_future;

import java.util.concurrent.*;

public class Main {
    private static final ExecutorService POOL_PAYMENT = Executors.newSingleThreadExecutor();

    private static Future<Integer> future;
    private static CompletableFuture<Integer> COMPLETABLE_FUTURE = new CompletableFuture<>();

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        doAll();

        System.out.println(future.get());

        System.out.println(COMPLETABLE_FUTURE.get());
    }

    private static int collectPayment() {
        try {
            TimeUnit.SECONDS.sleep(5);
            return 10_000;
        } catch (InterruptedException e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
    }

    private static int sendAnalytics() {
        try {
            TimeUnit.SECONDS.sleep(1);
            return 1_000;
        } catch (InterruptedException e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
    }

    private static void doAll() {
        future = POOL_PAYMENT.submit(Main::collectPayment);

        COMPLETABLE_FUTURE = CompletableFuture.supplyAsync(Main::sendAnalytics);
        POOL_PAYMENT.shutdown();
    }
}

package school.faang.bjs2_74694;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class MasterCardService {

    private static final int TEN_SECONDS_IN_MS = 10_000;
    private static final int ONE_SECOND_IN_MS = 1_000;

    static int collectPayment() {
        try {
            Thread.sleep(TEN_SECONDS_IN_MS);
            return 5_000;
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new RuntimeException(e);
        }
    }

    static int sendAnalytics() {
        try {
            Thread.sleep(ONE_SECOND_IN_MS);
            return 17_000;
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new RuntimeException(e);
        }
    }

    static void doAll() throws Exception{
        ExecutorService threads = Executors.newFixedThreadPool(1);
        Future<Integer> payment = threads.submit(MasterCardService::collectPayment);
        CompletableFuture
                .runAsync(() -> System.out.println(sendAnalytics()))
                .join();
        System.out.println(payment.get());
        threads.shutdown();
    }

    public static void main(String[] args) throws Exception{
        doAll();
    }
}

package school.faang.stripe;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class Main {
    private static final int AMOUNT_PAYMENT = 3000;
    private static final int AMOUNT_ANALYTICS = 10000;

    private static final int TIME_WAIT = 1;

    public static void main(String[] args) {
        MasterCardService cardService = new MasterCardService();
        ExecutorService service = Executors.newCachedThreadPool();

        Future<Integer> paymentFuture = service.submit(() -> cardService.collectPayment(AMOUNT_PAYMENT));
        CompletableFuture<Integer> analyticsFuture = CompletableFuture
                .supplyAsync(() -> cardService.sendAnalytics(AMOUNT_ANALYTICS));

        try {
            int payment = paymentFuture.get();
            System.out.printf("Payment %d\n", payment);
        } catch (InterruptedException | ExecutionException e) {
            throw new RuntimeException(e);
        }

        int analytics = analyticsFuture.join();
        System.out.printf("Analytics %d", analytics);

        gracefullyShutdown(service);
    }

    private static void gracefullyShutdown(ExecutorService service) {
        service.shutdown();
        try {
            if (!service.awaitTermination(1, TimeUnit.MINUTES)) {
                System.out.println("Есть не загруженные фотографии");
            }
        } catch (InterruptedException e) {
            service.shutdownNow();
        }
    }
}

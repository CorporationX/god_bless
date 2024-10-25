package school.faang.AsyncFuture;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class MasterCardService {
    public static void main(String[] args) throws InterruptedException {
        MasterCardService service = new MasterCardService();
        service.doAll();
    }

    static int collectPayment() {
        try {
            Thread.sleep(10_000);
            return 10_000;
        } catch (InterruptedException e) {
            throw new IllegalStateException("Something went wrong while collecting", e);
        }
    }

    static int sendAnalytics() {
        try {
            Thread.sleep(1_000);
            return 1_000;
        } catch (InterruptedException e) {
            throw new IllegalStateException("Something went wrong while sending", e);
        }
    }

    public void doAll(){
        ExecutorService service = Executors.newFixedThreadPool(2);

        CompletableFuture.supplyAsync(MasterCardService::sendAnalytics, service)
                .thenAccept(e -> System.out.println("Analytics sent: " + e));
        CompletableFuture.supplyAsync(MasterCardService::collectPayment, service)
                .thenAccept(e -> System.out.println("Payment collected: " + e));

        service.shutdown();

        try {
            if (!service.awaitTermination(15, TimeUnit.SECONDS)) {
                service.shutdownNow();
            }
        } catch (InterruptedException e) {
            throw new IllegalStateException("Something went wrong while awaiting termination", e);
        }
    }
}

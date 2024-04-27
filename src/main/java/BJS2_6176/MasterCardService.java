package BJS2_6176;

import java.util.concurrent.*;

public class MasterCardService {

    public static int collectPayment() {
        try {
            Thread.sleep(10_000);
            return 10_000;
        } catch (InterruptedException e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
    }

    public static int sendAnalytics() {
        try {
            Thread.sleep(1_000);
            return 1_000;
        } catch (InterruptedException e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
    }

    public static void doAll() {
        ExecutorService service = Executors.newSingleThreadExecutor();
        Future<Integer> payments = service.submit(MasterCardService::collectPayment);
        CompletableFuture<Integer> analytic = CompletableFuture.supplyAsync(MasterCardService::sendAnalytics);
        analytic.thenAccept(System.out::println);
        try {
            System.out.println(payments.get(20, TimeUnit.SECONDS));
        } catch (InterruptedException | ExecutionException | TimeoutException e) {
            throw new RuntimeException(e);
        } finally {
            service.shutdown();
        }
    }

    public static void main(String[] args) {
        doAll();
    }
}

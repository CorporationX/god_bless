package faang.school.godbless.asyncAndFuture;
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

    public void doAll(ExecutorService executor) {
        Future<Integer> paymentFuture = executor.submit(MasterCardService::collectPayment);

        CompletableFuture<Integer> analyticsFuture = CompletableFuture.supplyAsync(MasterCardService::sendAnalytics, executor);

        try {
            int analyticsResult = analyticsFuture.get();
            System.out.println("Analytics Result: " + analyticsResult);

            int paymentResult = paymentFuture.get();
            System.out.println("Payment Result: " + paymentResult);
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        MasterCardService service = new MasterCardService();

        int numThreads = Runtime.getRuntime().availableProcessors();
        ExecutorService executor = Executors.newFixedThreadPool(numThreads);

        service.doAll(executor);

        executor.shutdown();
    }
}
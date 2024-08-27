package faang.school.godbless.BJS2_24880;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class MasterCardService {
    private static final ExecutorService EXECUTOR = Executors.newCachedThreadPool();

    public static void doAll() {
        Future<Integer> payment = EXECUTOR.submit(MasterCardService::collectPayment);
        CompletableFuture<Integer> analytic = CompletableFuture.supplyAsync(
                MasterCardService::sendAnalystics,
                EXECUTOR
        );

        printAnalytic(analytic);
        printPayment(payment);

        System.out.println("All operations are completed!");
    }

    private static int collectPayment() {
        System.out.println("Payment start");
        try {
            Thread.sleep(10_000);
            System.out.println("Payment end");
            return 10_000;
        } catch (InterruptedException e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
    }

    private static int sendAnalystics() {
        System.out.println("Analystics start");
        try {
            Thread.sleep(5_000);
            System.out.println("Analystics end");
            return 1_000;
        } catch (InterruptedException e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
    }

    private static void printPayment(Future<Integer> payment) {
        try {
            System.out.println("The result of the payment: " + payment.get(20, TimeUnit.SECONDS));
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } catch (Exception e) {
            System.out.println("The result of the payment: " + e.getCause());
        }
    }

    private static void printAnalytic(CompletableFuture<Integer> analytic) {
        try {
            System.out.println("The result of the analysis: " + analytic.get(20, TimeUnit.SECONDS));
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        } catch (Exception e) {
            System.out.println("The result of the analysis: " + e.getCause());
        }
    }
}

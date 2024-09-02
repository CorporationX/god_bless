package faang.school.godbless.BJS227755;

import java.util.concurrent.*;

public class MasterCardService {
    private static final ExecutorService executor = Executors.newCachedThreadPool();

    public void doAll() {
        Future<Integer> payment = executor.submit(MasterCardService::collectPayment);
        CompletableFuture<Integer> analytic = CompletableFuture.supplyAsync(MasterCardService::sendAnalystics, executor);

        printAnalytic(analytic);
        printPayment(payment);

        System.out.println("All operations are completed!");
    }

    private static int collectPayment() {
        try {
            Thread.sleep(10_000);
            return 10_000;
        } catch (InterruptedException e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
    }

    private static int sendAnalystics() {
        try {
            Thread.sleep(1_000);
            return 1_000;
        } catch (InterruptedException e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
    }

    private static void printPayment(Future<Integer> payment) {
        try {
            System.out.println(payment.get(20, TimeUnit.SECONDS));
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } catch (Exception e) {
            System.out.println(e.getCause());
        }
    }

    private static void printAnalytic(CompletableFuture<Integer> analytic) {
        try {
            System.out.println(analytic.get(20, TimeUnit.SECONDS));
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        } catch (Exception e) {
            System.out.println(e.getCause());
        }
    }
}

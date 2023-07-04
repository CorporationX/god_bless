package faang.school.godbless.Sprint_5.Multithreading_Async.AsyncAndFuture;

import java.util.concurrent.*;

public class MasterCardService {
    static int collectPayment() {
        try {
            Thread.sleep(10_000);
            return 10_000;
        } catch (InterruptedException e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
    }

    static int sendAnalystics() {
        try {
            Thread.sleep(1_000);
            return 1_000;
        } catch (InterruptedException e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
    }

    public void doAll() throws ExecutionException, InterruptedException {
        ExecutorService executor = Executors.newFixedThreadPool(2);
        Future<Integer> payment = executor.submit(() -> collectPayment());

        CompletableFuture<Integer> analystics = CompletableFuture.supplyAsync(() -> sendAnalystics());

        int pay = payment.get();
        int analystic = analystics.get();
        System.out.printf("Analystics: %d\n", analystic);
        System.out.printf("Payment: %d\n", pay);
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        MasterCardService mc = new MasterCardService();
        mc.doAll();
    }
}

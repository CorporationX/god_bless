package faang.school.godbless.BJS2_13392;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class MasterCardService{
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

    public static void doAll()throws ExecutionException ,InterruptedException {
        ExecutorService executor = Executors.newCachedThreadPool();

        Future<Integer> payment = executor.submit(MasterCardService::collectPayment);
        CompletableFuture<Integer> analitics = CompletableFuture.supplyAsync(MasterCardService::sendAnalystics);

        int resultPayment = payment.get();
        System.out.println("Result Payment: " + resultPayment);

        int resultAnalitics = analitics.get();
        System.out.println("Result Analitics: " + resultAnalitics);

        executor.shutdown();
    }
}

package faang.school.godbless;

import lombok.val;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;


public class MasterCardService {

    public static void doAll() throws ExecutionException, InterruptedException, TimeoutException {
        ExecutorService executor = Executors.newFixedThreadPool(2);
        Future<Integer> payment = executor.submit(MasterCardService::collectPayment);
        CompletableFuture<Integer> analitics = CompletableFuture.supplyAsync(() -> sendAnalystics());
        val paymentResut = payment.get(1, TimeUnit.MINUTES);
        System.out.println("payment result " + paymentResut);

        val analiticsResult = analitics.get(1, TimeUnit.MINUTES);

        System.out.println("analitcs result " + analiticsResult);

        executor.shutdown();
        if (!executor.awaitTermination(1, TimeUnit.MINUTES)) {
            executor.shutdown();
        }
    }

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


}

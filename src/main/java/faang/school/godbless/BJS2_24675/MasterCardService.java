package faang.school.godbless.BJS2_24675;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class MasterCardService {

    public static void doAll() {
        Future<Integer> paymentRes = Executors.newSingleThreadExecutor().submit(() -> collectPayment());
        CompletableFuture<Integer> analysticsRes = CompletableFuture.supplyAsync(() -> sendAnalystics());

        try {
            int completableFutureRes = analysticsRes.get();
            System.out.println(completableFutureRes);

            int futureRes = paymentRes.get();
            System.out.println(futureRes);
        } catch (CompletionException | InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
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

}

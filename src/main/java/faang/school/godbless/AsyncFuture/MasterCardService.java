package faang.school.godbless.AsyncFuture;

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

    public static void doAll() throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(2);

        try {
            Future<Integer> future1 = executorService.submit(MasterCardService::collectPayment);
            Future<Integer> future2 = CompletableFuture.supplyAsync(MasterCardService::sendAnalystics);

            int paymentResult = future1.get();
            int analysticsResult = future2.get();
            System.out.println("Payment result: " + paymentResult);
            System.out.println("Analystic result: " + analysticsResult);
        } finally {
            executorService.shutdown();
        }




    }
}


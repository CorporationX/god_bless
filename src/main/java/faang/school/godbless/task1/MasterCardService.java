package faang.school.godbless.task1;

import java.util.concurrent.*;

public class MasterCardService {


//    public void doAll() throws ExecutionException, InterruptedException {
//
//        Future<Integer> result = executorService.submit(() -> collectPayment());
//
//        CompletableFuture<Integer> result2 = CompletableFuture.supplyAsync(() -> sendAnalytics(), executorService);
//
//        int realResult1 = result.get();
//        int realResult2 = result2.get();
//    }


    public int collectPayment() {
        try {
            Thread.sleep(5000);
            return 5000;
        } catch (InterruptedException e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
    }

    public int sendAnalytics() {
        try {
            Thread.sleep(1000);
            return 1000;
        } catch (InterruptedException e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
    }
}

package faang.school.godbless.BJS2_3338;

import java.util.concurrent.*;

public class MasterCardService {
    static void doAll() {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        Future<Integer> futureCollect = executorService.submit(MasterCardService::collectPayment);
        CompletableFuture<Integer> futureSend = CompletableFuture.supplyAsync(MasterCardService::sendAnalystics);
        futureSend.join();
        try {
            System.out.println(futureSend.get());
            System.out.println(futureCollect.get());
        } catch (InterruptedException | ExecutionException e) {
            throw new RuntimeException(e);
        }
        executorService.shutdown();
    }

    static int collectPayment() {
        try {
            Thread.sleep(3_000);
            return 10_000;
        } catch (InterruptedException e) {
            throw new RuntimeException();
        }
    }

    static int sendAnalystics() {
        try {
            Thread.sleep(1_000);
            return 1_000;
        } catch (InterruptedException e) {
            throw new RuntimeException();
        }
    }

    public static void main(String[] args) {
        doAll();
    }
}

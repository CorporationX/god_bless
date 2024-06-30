package faang.school.godbless.BJS2_13439;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

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

    static int sendAnalytics() {
        try {
            Thread.sleep(1_000);
            return 1_000;
        } catch (InterruptedException e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
    }

    public void doAll() throws ExecutionException, InterruptedException {
        try (ExecutorService executor = Executors.newSingleThreadExecutor()) {
            Future<Integer> resultOfCollect = executor.submit(MasterCardService::collectPayment);
            CompletableFuture<Integer> resultOfSending = CompletableFuture.supplyAsync(MasterCardService::sendAnalytics, executor);

            System.out.println("Результат sendAnalytics - " + resultOfSending.get());
            System.out.println("Результат collectPayment - " + resultOfCollect.get());
        }
    }
}
package faang.school.godbless.sprint_4.task_1_future;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class MasterCardService {
    private static final int COUNT_THREAD = 2;
    private static final ExecutorService executor = Executors.newFixedThreadPool(COUNT_THREAD);

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
        Future<Integer> future = executor.submit(MasterCardService::collectPayment);
        CompletableFuture<Integer> completableFuture = CompletableFuture.supplyAsync(MasterCardService::sendAnalystics, executor);

        System.out.println(completableFuture.get());
        System.out.println(future.get());

        shutdown();
    }

    private static void shutdown() {
        executor.shutdown();
    }

    public static void main(String[] args) {
        MasterCardService masterCardService = new MasterCardService();

        try {
            masterCardService.doAll();
        } catch (ExecutionException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}

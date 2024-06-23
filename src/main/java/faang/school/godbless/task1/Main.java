package faang.school.godbless.task1;

import java.util.concurrent.*;

public class Main {
    private static ExecutorService executorService = Executors.newFixedThreadPool(2);

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        MasterCardService masterCardService = new MasterCardService();
        doAll(masterCardService);

    }

    public static void doAll(MasterCardService masterCardService) throws ExecutionException, InterruptedException {

        Future<Integer> result = executorService.submit(masterCardService::collectPayment);

        CompletableFuture<Integer> result2 = CompletableFuture.supplyAsync(masterCardService::sendAnalytics, executorService);

        int realResult2 = result2.get();
        System.out.println(realResult2);
        int realResult1 = result.get();
        System.out.println(realResult1);

        executorService.shutdown();
    }
}

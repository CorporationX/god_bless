package faang.school.godbless.Asynchronicity;

import java.util.concurrent.*;

public class Main {
    private static final int COUNT_THREAD = 2;
    private static final ExecutorService executorService = Executors.newFixedThreadPool(COUNT_THREAD);

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        MasterCardService masterCardService = new MasterCardService();
        doAll(masterCardService);
    }

    public static void doAll(MasterCardService masterCardService) throws ExecutionException, InterruptedException {
        Future<Integer> resultOne = executorService.submit(masterCardService::collectPayment);
        CompletableFuture<Integer> resultTwo = CompletableFuture.supplyAsync(masterCardService::sendAnalystics, executorService);

        int result2 = resultTwo.get();
        System.out.println(result2);
        int result1 = resultOne.get();
        System.out.println(result1);

        executorService.shutdown();
    }

}

package faang.school.godbless.multithreadingAsync;

import java.util.concurrent.*;

public class AsynchronismFuture {

    public static void main(String[] args) {
        try {
            doAll();
        } catch (ExecutionException | InterruptedException e) {
            System.out.println("Платеж прерван");
            Thread.currentThread().interrupt();
            e.printStackTrace();
        }
    }

    public static void doAll() throws ExecutionException, InterruptedException {
        MasterCardService masterCardService = new MasterCardService();
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        Future<Integer> resultPayment = executorService.submit(masterCardService::collectPayment);
        CompletableFuture<Integer> resultAnalystics = CompletableFuture.supplyAsync(masterCardService::sendAnalystics);
        System.out.println("Result Analystics " + resultAnalystics.get());
        System.out.println("Result Payment " + resultPayment.get());
        executorService.shutdown();
    }

}

package faang.school.godbless.multi_asyn.task1asyn_future;

import java.util.concurrent.*;

public class Main {
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
        ExecutorService executorService = Executors.newFixedThreadPool(1);

        Future<Integer> resultPayment = executorService.submit(masterCardService::collectPayment);
        CompletableFuture<Integer> resultAnalytics = CompletableFuture.supplyAsync(masterCardService::sendAnalytics);

        // В условии написно иcпользовать join, но как я понял особых различий нет
        System.out.println("Время аналитики: " + resultAnalytics.get() + " ms");
        System.out.println("Ждем завершения оплаты...");
        System.out.println("Время оплаты: " + resultPayment.get() + " ms");

        executorService.shutdown();
    }
}

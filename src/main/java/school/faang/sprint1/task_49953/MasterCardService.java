package school.faang.sprint1.task_49953;

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

    static int sendAnalytics() {
        try {
            Thread.sleep(1_000);
            return 1_000;
        } catch (InterruptedException e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
    }

    public static void addAll() throws ExecutionException, InterruptedException {
        ExecutorService executor = Executors.newFixedThreadPool(1);
        Future<Integer> collectingPay = executor.submit(() -> collectPayment());
        CompletableFuture<Integer> sendingAnalytics = CompletableFuture.supplyAsync(() -> sendAnalytics());
        Integer analyticResult = sendingAnalytics.join();
        System.out.println("Аналитика отправлена " + analyticResult);
        Integer analyticPayResult = collectingPay.get();
        System.out.println("Платёж обработан " + analyticPayResult);
    }
}
package school.faang.task_49873;

import java.util.concurrent.*;

public class Main {
    public static void main(String[] args) {
        MasterCardService masterCardService = new MasterCardService();
        startThreads(masterCardService);
    }

    public static void startThreads(MasterCardService service) {
        ExecutorService executor = Executors.newSingleThreadExecutor();
        Future<Integer> paymentFuture = executor.submit(() -> service.collectPayment());

        CompletableFuture<Integer> analyticFuture = CompletableFuture.supplyAsync(() -> service.sendAnalytics());
        Integer analytic = analyticFuture.join();
        MasterCardService.LOGGER.debug(String.valueOf(analytic));
        try {
            Integer paymentResult = paymentFuture.get();
            MasterCardService.LOGGER.debug(String.valueOf(paymentResult));
        } catch (InterruptedException e) {
            MasterCardService.LOGGER.error("Ошибка. Прерывание потока, {}", e.getMessage());
        } catch (ExecutionException e) {
            MasterCardService.LOGGER.error("Ошибка в попытке получения результата, {}", e.getMessage());
        }
    }
}

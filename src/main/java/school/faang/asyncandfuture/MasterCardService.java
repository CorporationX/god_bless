package school.faang.asyncandfuture;

import lombok.Data;

import java.util.concurrent.*;

@Data
public class MasterCardService {

    public void doAll() throws ExecutionException, InterruptedException, TimeoutException {
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        Future<Integer> payment = executorService.submit(MasterCardService::collectPayment);
        CompletableFuture<Integer> analytic = CompletableFuture.supplyAsync(MasterCardService::sendAnalytics, executorService);

        int resultPayment = payment.get(20000, TimeUnit.SECONDS);
        int resultAnalytic = analytic.get(20000, TimeUnit.SECONDS);

        executorService.shutdown();

        System.out.println("Аналитика отправлена: " + resultAnalytic + ", Платеж выполнен: " + resultPayment);

    }

    static int collectPayment() {
        try {
            Thread.sleep(10000);
            return 10000;
        } catch (InterruptedException e) {
            throw new IllegalStateException("Ошибка в потоке" + e.getMessage());
        }
    }

    static int sendAnalytics() {
        try {
            Thread.sleep(1000);
            return 1000;
        } catch (InterruptedException e) {
            throw new IllegalStateException("Ошибка в потоке" + e.getMessage());
        }
    }
}

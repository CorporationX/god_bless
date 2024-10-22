package school.faang.asyncandfuture;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.*;

@Data
@Slf4j
public class MasterCardService {
    private static final Integer PAYMENT_SLEEP_TIME = 10000;
    private static final Integer ANALYTIC_SLEEP_TIME = 1000;
    private static final Integer TIMEOUT_TIME = 1000;

    private final ExecutorService executorService = Executors.newFixedThreadPool(3);

    public void doAll() throws ExecutionException, InterruptedException, TimeoutException {
        Future<Integer> payment = executorService.submit(MasterCardService::collectPayment);
        CompletableFuture<Integer> analytic = CompletableFuture.supplyAsync(MasterCardService::sendAnalytics, executorService);

        int resultPayment = payment.get(TIMEOUT_TIME, TimeUnit.SECONDS);
        int resultAnalytic = analytic.get(TIMEOUT_TIME, TimeUnit.SECONDS);

        executorService.shutdown();

        System.out.println("Аналитика отправлена: " + resultAnalytic + ", Платеж выполнен: " + resultPayment);

    }

    static int collectPayment() {
        try {
            Thread.sleep(PAYMENT_SLEEP_TIME);
            return PAYMENT_SLEEP_TIME;
        } catch (InterruptedException e) {
            log.error(e.getMessage());
            throw new IllegalStateException("Ошибка в потоке" + e.getMessage());
        }
    }

    static int sendAnalytics() {
        try {
            Thread.sleep(ANALYTIC_SLEEP_TIME);
            return ANALYTIC_SLEEP_TIME;
        } catch (InterruptedException e) {
            log.error(e.getMessage());
            throw new IllegalStateException("Ошибка в потоке" + e.getMessage());
        }
    }
}

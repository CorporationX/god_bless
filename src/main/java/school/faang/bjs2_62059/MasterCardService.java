package school.faang.bjs2_62059;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class MasterCardService {

    private static final int TEN_SECONDS_IN_MS = 10000;
    private static final int ONE_SECOND_IN_MS = 1000;
    private static final int FIVE_SECONDS_IN_MS = 5000;
    private static final int SEVENTEEN_SECONDS_IN_MS = 17000;
    private static final String EXCEPTION_MESSAGE = "Произошла ошибка: %s\n";

    public int collectPayment() {
        try {
            Thread.sleep(TEN_SECONDS_IN_MS);
            return FIVE_SECONDS_IN_MS;
        } catch (InterruptedException e) {
            System.out.printf(EXCEPTION_MESSAGE, e.getMessage());
            Thread.currentThread().interrupt();
            throw new RuntimeException(e);
        }
    }

    public int sendAnalytics() {
        try {
            Thread.sleep(ONE_SECOND_IN_MS);
            return SEVENTEEN_SECONDS_IN_MS;
        } catch (InterruptedException e) {
            System.out.printf(EXCEPTION_MESSAGE, e.getMessage());
            Thread.currentThread().interrupt();
            throw new RuntimeException(e);
        }
    }

    public void doAll() {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        Future<Integer> futurePaymentResult = executorService.submit(this::collectPayment);
        CompletableFuture<Integer> completableAnalyticResult = CompletableFuture.supplyAsync(this::sendAnalytics);
        try {
            System.out.printf("Аналитика отправлена: %d%n", completableAnalyticResult.get());
            System.out.printf("Платеж выполнен: %d%n", futurePaymentResult.get());
        } catch (InterruptedException | ExecutionException e) {
            System.out.printf(EXCEPTION_MESSAGE, e.getMessage());
            Thread.currentThread().interrupt();
        } finally {
            executorService.shutdown();
        }
    }

}

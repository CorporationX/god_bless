package school.faang.sprint4.future;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class MasterCardService {
    private final ExecutorService executor = Executors.newFixedThreadPool(8);
    private static final Integer PAYMENT_DELAY_SECONDS = 10;
    private static final Integer PAYMENT = 5_000;
    private static final Integer ANALYTICS_DELAY_SECONDS = 1;
    private static final Integer ANALYTICS = 17_000;
    private static final Integer TIME_AWAIT_MINUTE = 5;

    public Integer collectPayment() {
        try {
            System.out.printf("Платеж начался %s\n", Thread.currentThread().getName());
            Thread.sleep(TimeUnit.SECONDS.toMillis(PAYMENT_DELAY_SECONDS));
            return PAYMENT;
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new RuntimeException(e);
        }
    }

    public int sendAnalytics() {
        try {
            System.out.printf("Начался сбор статистики %s\n", Thread.currentThread().getName());
            Thread.sleep(TimeUnit.SECONDS.toMillis(ANALYTICS_DELAY_SECONDS));
            return ANALYTICS;
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new RuntimeException(e);
        }
    }

    public void doAll() {
        try {
            Future<Integer> payment = executor.submit(this::collectPayment);
            CompletableFuture<Integer> analytics = CompletableFuture.supplyAsync(this::sendAnalytics, executor);

            Integer analyticsResult = analytics.join();
            System.out.printf("analyticsResult = %d\n", analyticsResult);
            Integer paymentResult = payment.get();
            System.out.printf("paymentResult = %d\n", paymentResult);

        } catch (InterruptedException | ExecutionException exception) {
            System.out.printf("Future get exception %s\n", exception.getMessage());
        } catch (RuntimeException exception) {
            System.out.printf("Thread sleep exception %s\n", exception.getMessage());
        } finally {
            gracefullyShutdown();
        }
    }

    private void gracefullyShutdown() {
        executor.shutdown();
        try {
            if (executor.awaitTermination(TIME_AWAIT_MINUTE, TimeUnit.MINUTES)) {
                System.out.println("Потоки завершили работу");
            } else {
                System.out.println("Ошибка ожидания окончания работы потоков");
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            System.out.println("Прерывание ожидания окончания работы потоков");
            Thread.currentThread().interrupt();
        }
    }


}

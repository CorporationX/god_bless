package asinc.future;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class MasterCardService {
    private static final int PAYMENT_TIME = 10000;
    private static final int ANALYTICS_TIME = 1000;

    public int collectPayment() {
        try {
            Thread.sleep(PAYMENT_TIME);
            return 10000;
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new IllegalStateException("Платеж был прерван", e);
        }
    }

    public int sendAnalytics() {
        try {
            Thread.sleep(ANALYTICS_TIME);
            return 1000;
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new IllegalStateException("Отправка аналитики была прервана", e);
        }
    }

    public void doAll() {
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        Future<Integer> payments = executorService.submit(this::collectPayment);
        CompletableFuture<Integer> analytics = CompletableFuture.supplyAsync(this::sendAnalytics);
        try {
            Integer resultAnalytics = analytics.join();
            System.out.println("Аналитика отправлена: " + resultAnalytics);
        } catch (CompletionException e) {
            System.err.println("Ошибка при отправке аналитики: " + e.getCause());
        }
        try {
            Integer resultPayment = payments.get();
            System.out.println("Платеж выполнен: " + resultPayment);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.err.println("Поток был прерван: " + e.getMessage());
        } catch (ExecutionException e) {
            System.err.println("Ошибка при выполнении платежа: " + e.getCause());
        } finally {
            executorService.shutdown();
        }
    }
}

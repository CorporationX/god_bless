package school.faang.bjs2_82485;

import java.util.Random;
import java.util.concurrent.CancellationException;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class MasterCardService {
    private static final int TEN_SECONDS_IN_MS = 1_000;
    private static final int ONE_SECOND_IN_MS = 1_000;
    private static final Random RANDOM = new Random();
    private static final int N_THREADS = 2;

    static boolean collectPayment() {
        try {
            Thread.sleep(TEN_SECONDS_IN_MS);
            return RANDOM.nextDouble() < 0.8;
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new RuntimeException(e);
        }
    }

    static boolean sendAnalytics() {
        try {
            Thread.sleep(ONE_SECOND_IN_MS);
            return RANDOM.nextDouble() < 0.9;
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new RuntimeException(e);
        }
    }

    public void doAll(int payment, int analytic) {
        ExecutorService executorService = Executors.newFixedThreadPool(N_THREADS);
        Future<Boolean> paymentsResult = executorService.submit(MasterCardService::collectPayment);

        CompletableFuture<Boolean> analyticsResult = CompletableFuture
                .supplyAsync(MasterCardService::sendAnalytics, executorService);

        Runnable getPayment = () -> {
            try {
                if (paymentsResult.get()) {
                    System.out.println("Платеж не прошел");
                    return;
                }
                System.out.printf("Платеж выполнен: %s%n", payment);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.out.println("Ожидание прервано");
            } catch (ExecutionException e) {
                System.out.printf("Ошибка выролнения задачи: %s%n", e.getCause().getMessage());
            } catch (CancellationException e) {
                System.out.println("Ожидание было прервано");
            } finally {
                executorService.shutdown();
            }
        };

        analyticsResult
                .thenAccept(result -> {
                    if (result) {
                        System.out.printf("Аналитика отправлена: %s%n", analytic);
                        return;
                    }
                    System.out.println("Аналитика не отправлена");
                })
                .thenRun(getPayment);
    }
}

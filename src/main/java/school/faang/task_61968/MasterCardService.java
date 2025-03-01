package school.faang.task_61968;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

@Slf4j
public class MasterCardService {
    private static final int TEN_SECONDS_IN_MS = 10_000;
    private static final int ONE_SECOND_IN_MS = 1_000;
    private static final int PAYMENT_VALUE = 5_000;
    private static final int ANALYTICS_VALUE = 17_000;
    private static final int WAIT_TIME = 1;
    private static final String COLLECT_PAYMENT = MasterCardMessage.COLLECT_PAYMENT.getMessage();
    private static final String SEND_ANALYTICS = MasterCardMessage.SEND_ANALYTICS.getMessage();
    private static final String PROCESS_START_MESSAGE = MasterCardMessage.PROCESS_START_MESSAGE.getMessage();
    private static final String INTERRUPT_SLEEP_MESSAGE = MasterCardMessage.INTERRUPT_SLEEP_MESSAGE.getMessage();
    private static final String ANALYTICS_RESULT_MESSAGE = MasterCardMessage.ANALYTICS_RESULT_MESSAGE.getMessage();
    private static final String PAYMENT_RESULT_MESSAGE = MasterCardMessage.PAYMENT_RESULT_MESSAGE.getMessage();

    public static int collectPayment() {
        return processSimulation(COLLECT_PAYMENT, TEN_SECONDS_IN_MS, PAYMENT_VALUE);
    }

    public static int sendAnalytics() {
        return processSimulation(SEND_ANALYTICS, ONE_SECOND_IN_MS, ANALYTICS_VALUE);
    }

    public void doAll() {
        ExecutorService paymentExecutor = Executors.newSingleThreadExecutor();
        ExecutorService analyticsExecutor = Executors.newSingleThreadExecutor();
        Future<Integer> paymentFuture = paymentExecutor.submit(MasterCardService::collectPayment);
        CompletableFuture<Integer> analyticsFuture
                = CompletableFuture.supplyAsync(MasterCardService::sendAnalytics, analyticsExecutor);

        if (!paymentFuture.isDone() || !analyticsFuture.isDone()) {
            log.info("Выполняется обработка платежа и сбор статистики...");
        }

        try {
            log.info(ANALYTICS_RESULT_MESSAGE, analyticsFuture.join());
            log.info(PAYMENT_RESULT_MESSAGE, paymentFuture.get());
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            log.warn("Ожидание завершения задачи прервано");
            throw new RuntimeException(e);
        } catch (ExecutionException e) {
            throw new RuntimeException(e);
        } finally {
            shutdownExecutor(paymentExecutor);
            shutdownExecutor(analyticsExecutor);
        }
    }

    private static int processSimulation(String process, int leadTime, int returnValue) {
        try {
            log.info(PROCESS_START_MESSAGE, process);
            Thread.sleep(leadTime);
            return returnValue;
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            log.warn(INTERRUPT_SLEEP_MESSAGE, Thread.currentThread().getName());
            throw new RuntimeException(e);
        }
    }

    private void shutdownExecutor(ExecutorService executor) {
        executor.shutdown();
        try {
            if (!executor.awaitTermination(WAIT_TIME, TimeUnit.MINUTES)) {
                log.warn("Не все задачи выполнились за отведённое время!");
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            log.warn("Ожидание завершения задач прервано");
            throw new RuntimeException(e);
        } finally {
            if (!executor.isTerminated()) {
                executor.shutdownNow();
            }
        }
    }
}

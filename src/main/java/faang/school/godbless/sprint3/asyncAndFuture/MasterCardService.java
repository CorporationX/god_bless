package faang.school.godbless.sprint3.asyncAndFuture;

import ch.qos.logback.core.joran.conditional.ThenAction;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

@Slf4j
public class MasterCardService {

    private final ExecutorService executorService;

    public MasterCardService(ExecutorService executorService) {
        this.executorService = executorService;
    }

    public int collectPayment() {
        int result = -1;
        try {
            log.info("collectPayment start");
            Thread.sleep(10_000);
            log.info("collectPayment end");
            result = 10_000;
        } catch (InterruptedException e) {
            log.error("collectPayment interrupted: {}.", e.getMessage());
            Thread.currentThread().interrupt();
        } finally {
            return result;
        }
    }

    public int sendAnalytics() {
        int result = -1;
        try {
            log.info("sendAnalytics start");
            Thread.sleep(2_000);
            log.info("sendAnalytics end");
            result = 1_000;
        } catch (InterruptedException e) {
            log.error("sendAnalytics interrupted: {}", e.getMessage());
            Thread.currentThread().interrupt();
        } finally {
            return result;
        }
    }

    public void doAll() {
        log.info("thread doAll method {}", Thread.currentThread().getName());
        Future<Integer> submitFuture = executorService.submit(this::collectPayment);

        CompletableFuture<Integer> sendAnalyticsCompletableFuture = CompletableFuture
                .supplyAsync(this::sendAnalytics, executorService)
                .thenApply(result -> {
                    log.info("{} the result of completable future: {}", Thread.currentThread().getName(), result);
                    return result;
                });

        executorService.shutdown();

        try {
            if (!executorService.awaitTermination(30L, TimeUnit.SECONDS)) {
                log.info("Executor threads hasn't been done tasks. start closing threads immediately");
                executorService.shutdownNow();

                if (!executorService.awaitTermination(2L, TimeUnit.SECONDS)) {
                    log.error("Executor did not terminate");
                }
            } else {
                log.info("all threads has been done tasks");
            }
        } catch (InterruptedException e) {
            log.error("error: {}", e.getMessage());
        }

        while (true) {
            if (!sendAnalyticsCompletableFuture.isDone() && !submitFuture.isDone()) {
                log.info("doing something");
            } else {
                try {
                    Integer sendAnalyticsResult = sendAnalyticsCompletableFuture.get();
                    log.info("{} send analytics result: {}", Thread.currentThread().getName(), sendAnalyticsResult);
                    Integer collectPaymentResult = submitFuture.get();
                    log.info("{} collect payment result: {}", Thread.currentThread().getName(), collectPaymentResult);

                } catch (InterruptedException | ExecutionException e) {
                    e.printStackTrace();
                } finally {
                    break;
                }
            }
        }
    }
}

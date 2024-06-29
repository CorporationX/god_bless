package faang.school.godbless.sprint3.asyncAndFuture;

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
        try {
            log.info("collectPayment start");
            Thread.sleep(2_000);
            log.info("collectPayment end");
            return 10_000;
        } catch (InterruptedException e) {
            log.error("error: {}", e.getMessage());
            e.printStackTrace();
            return -1;
        }
    }

    public int sendAnalytics() {
        try {
            log.info("sendAnalytics start");
            Thread.sleep(1_000);
            log.info("sendAnalytics end");
            return 1_000;
        } catch (InterruptedException e) {
            log.error("error: {}", e.getMessage());
            e.printStackTrace();
            return -1;
        }
    }

    public void doAll() {
        Future<Integer> submitFuture = executorService.submit(this::collectPayment);

        CompletableFuture
                .supplyAsync(this::sendAnalytics, executorService)
                .thenAccept(result -> log.info("the result of completable future: {}", result))
                .thenRun(() -> {
                    while (!submitFuture.isDone()) {
                        System.out.println("submit future hasn't ready, do something...");
                    }

                    Integer futureResult = null;
                    try {
                        futureResult = submitFuture.get();
                    } catch (InterruptedException | ExecutionException e) {
                        log.error("error : {}", e.getMessage());
                        e.printStackTrace();
                    } finally {
                        log.info("the result of future: {}", futureResult);
                    }
                });


        executorService.shutdown();


        try {
            if (!executorService.awaitTermination(20L, TimeUnit.SECONDS)) {
                log.info("threads hasn't been done tasks. start closing threads immediately");
                executorService.shutdown();
            } else {
                log.info("all threads has been done tasks");
            }
        } catch (InterruptedException e) {
            log.error("error: {}", e.getMessage());
        }
    }
}

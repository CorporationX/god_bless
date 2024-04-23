package faang.school.godbless.async.future;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


@Slf4j
public class Main {
    public static void main(String[] args) {
        MasterCardService msService =  new MasterCardService();

        Runnable firstOperation = () -> log.info("Collected payment = " + msService.collectPayment());
        Runnable secondOperation = () -> log.info("Received analytics = " + msService.sendAnalytics());

        doAll(firstOperation, secondOperation);

    }

    public static void doAll(Runnable firstOperation, Runnable secondOperation) {
        ExecutorService executorService = Executors.newCachedThreadPool();

        var firstOperationResult = executorService.submit(firstOperation);

        var secondOperationResult = CompletableFuture.runAsync(secondOperation);

        secondOperationResult.join();

        try {
            firstOperationResult.get();
        } catch (InterruptedException e) {
            log.error("First operation in doAll() method was interrupted", e);
        } catch (ExecutionException e) {
            log.error("Attempt to get result of first operation failed.", e);
        }

        executorService.shutdown();
    }
}

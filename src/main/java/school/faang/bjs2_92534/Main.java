package school.faang.bjs2_92534;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

@Slf4j
public class Main {
    private static final int POOL_SIZE_THREAD = 2;

    public static void main(String[] args) {
        MasterCardService masterCardService = new MasterCardService();

        ExecutorService executorService = Executors.newFixedThreadPool(POOL_SIZE_THREAD);
        Future<Integer> futureCollectPayment = executorService.submit(masterCardService::collectPayment);

        CompletableFuture<Integer> futureSendAnalytics = CompletableFuture
                .supplyAsync(masterCardService::sendAnalytics, executorService);

        int resultSendAnalytics = futureSendAnalytics.join();
        log.info("результат аналитики: {}", resultSendAnalytics);

        try {
            int resultCollectPayment = futureCollectPayment.get();
            log.info("Счет на оплату: {}", resultCollectPayment);
        } catch (InterruptedException | ExecutionException e) {
            log.error("Возникла ошЫбка", e.getMessage());
        }
        masterCardService.doAll();

        executorService.shutdownNow();

    }
}

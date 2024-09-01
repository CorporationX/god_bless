package faang.school.godbless.collectingdataforthereport;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Slf4j
public class Main {
    private static final int NUMBER_OF_STORES = 5;

    public static void main(String[] args) {
        ReportGenerator generator = new ReportGenerator();
        CountDownLatch latch = new CountDownLatch(NUMBER_OF_STORES);
        List<SalesData> salesDataList = new ArrayList<>();
        ExecutorService threadPool = Executors.newFixedThreadPool(NUMBER_OF_STORES);
        for (int i = 1; i <= NUMBER_OF_STORES; i++) {
            Store store = new Store(i);
            threadPool.execute(new DataCollector(store, salesDataList, latch));
        }
        try {
            latch.await();
        } catch (InterruptedException e) {
            log.error(e.getMessage());
            Thread.currentThread().interrupt();
        }
        generator.generateReport(salesDataList);
        shutdown(threadPool);
    }

    private static void shutdown(ExecutorService threadPool) {
        threadPool.shutdown();
        try {
            if (!threadPool.awaitTermination(10, TimeUnit.SECONDS)) {
                threadPool.shutdownNow();
                if (!threadPool.awaitTermination(10, TimeUnit.SECONDS)) {
                    log.error("Pool did not terminate");
                }
            }
        } catch (InterruptedException e) {
            threadPool.shutdownNow();
            Thread.currentThread().interrupt();
        }
    }
}
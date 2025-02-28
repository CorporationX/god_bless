package bjs2_62865;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Slf4j
public class Main {
    public static final int WAIT_TERMINATION_SECOND = 3;
    public static final int STORE_COUNT = 5;

    public static void main(String[] args) {
        var latch = new CountDownLatch(STORE_COUNT);
        var executor = Executors.newFixedThreadPool(STORE_COUNT);
        List<SalesData> salesDataList = new ArrayList<>();

        for (int i = 0; i < STORE_COUNT; i++) {
            executor.submit(new DataCollector(i, latch, salesDataList));
        }
        executor.shutdown();

        try {
            latch.await(WAIT_TERMINATION_SECOND, TimeUnit.SECONDS);

            if (!executor.awaitTermination(WAIT_TERMINATION_SECOND, TimeUnit.SECONDS)) {
                log.error("Потоки не завершились за заданное время");
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            log.error("Ошибка при ожидании завершения потоков {}", e.getMessage(), e);
            executor.shutdownNow();
        }

        var reportGenerator = new ReportGenerator(salesDataList);
        reportGenerator.generateReport();
    }
}

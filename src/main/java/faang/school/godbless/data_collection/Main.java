package faang.school.godbless.data_collection;

import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Slf4j
public class Main {
    private static final int THREAD_NUM = 5;
    private static final int TIME_LIMIT_IN_SECONDS = 10;

    private static final ExecutorService executorService = Executors.newFixedThreadPool(THREAD_NUM);

    public static void main(String[] args) {
        ReportGenerator reportGenerator = new ReportGenerator();
        CountDownLatch countDownLatch = new CountDownLatch(THREAD_NUM);
        List<SalesData> salesDataList = getSalesDataList();

        for (int i = 0; i < THREAD_NUM; i++) {
            int fetchIndex = i;
            executorService.submit(() -> {
                DataCollector dataCollector = new DataCollector(10, countDownLatch);
                dataCollector.fetchSalesFromStoreToList(salesDataList.get(fetchIndex));
            });
        }

        try {
            countDownLatch.await();
            reportGenerator.showReport(salesDataList);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            log.warn("Report Generation awaiting was interrupted");
        }

        executorService.shutdown();
        try {
            boolean isFinished = executorService.awaitTermination(TIME_LIMIT_IN_SECONDS, TimeUnit.SECONDS);
            if (isFinished) {
                log.info("Threads awaiting was terminated successfully");
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            log.warn("Executor Service awaiting was interrupted");
        }
    }

    private static List<SalesData> getSalesDataList() {
        return List.of(
                new SalesData(1),
                new SalesData(2),
                new SalesData(3),
                new SalesData(4),
                new SalesData(5)
        );
    }
}

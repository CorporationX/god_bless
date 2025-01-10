package school.faang.sprint_4.task_50951;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Slf4j
public class Main {
    private static final int NUMBER_OF_COLLECTORS = 10;
    private static final int NUMBER_OF_SALES_PER_STORE = 15;
    private static final int AWAIT_TIME = 5;

    public static void main(String[] args) {
        ReportGenerator reportGenerator = new ReportGenerator();
        CountDownLatch countDownLatch = new CountDownLatch(NUMBER_OF_COLLECTORS);
        ExecutorService executorService = Executors.newCachedThreadPool();

        for (int i = 1; i <= NUMBER_OF_COLLECTORS; i++) {
            SalesData salesData = new SalesData(i);
            for (int j = 1; j <= NUMBER_OF_SALES_PER_STORE; j++) {
                salesData.addSales(new Sales(j, j * 10));
            }
            executorService.submit(new DataCollector(i, countDownLatch, reportGenerator));
            reportGenerator.addSalesData(salesData);
        }

        try {
            countDownLatch.await();
            reportGenerator.generateReport();
            executorService.shutdown();

            if (!executorService.awaitTermination(AWAIT_TIME, TimeUnit.SECONDS)) {
                log.info("Await timed out. Shutting down...");
                executorService.shutdownNow();
            }
        } catch (InterruptedException e) {
            log.info("Main thread interrupted. Shutting down...");
            executorService.shutdownNow();
        }
    }
}

package school.faang.sprint_4.task_51010;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Slf4j
public class Main {
    public static void main(String[] args) {
        int numberOfStores = 3;
        CountDownLatch latch = new CountDownLatch(numberOfStores);
        List<SalesData> salesDataList = new ArrayList<>();

        ExecutorService executor = Executors.newFixedThreadPool(numberOfStores);

        for (int i = 1; i <= numberOfStores; i++) {
            executor.submit(new DataCollector(i, latch, salesDataList));
        }

        try {
            latch.await();
        } catch (InterruptedException e) {
            log.error("Произошла ошибка во время ожидания потока");
        }

        ReportGenerator reportGenerator = new ReportGenerator(salesDataList);
        reportGenerator.generateReport();

        executor.shutdown();
    }

}

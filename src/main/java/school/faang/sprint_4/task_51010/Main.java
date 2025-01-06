package school.faang.sprint_4.task_51010;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Slf4j
public class Main {

    public static final int TIMEOUT = 30;

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
            Thread.currentThread().interrupt();
        }

        ReportGenerator reportGenerator = new ReportGenerator(salesDataList);
        reportGenerator.generateReport();

        executor.shutdown();
        try {
            if (executor.awaitTermination(TIMEOUT, TimeUnit.SECONDS)) {
                log.info("Все задачи завершены");
            } else {
                log.error("Задачи не выполнены за отведенное время");
            }
        } catch (InterruptedException e) {
            log.error("Произошла ошибка во время ожидания завершения задачи");
            Thread.currentThread().interrupt();
        }
    }

}

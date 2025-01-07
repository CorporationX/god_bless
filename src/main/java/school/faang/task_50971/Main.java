package school.faang.task_50971;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

@Slf4j
public class Main {
    private static final int TERMINATION_DELAY = 15;
    private static final int NUM_THREADS = 3;

    public static void main(String[] args) {
        List<SalesData> salesDataList = new ArrayList<>();
        CountDownLatch latch = new CountDownLatch(NUM_THREADS);
        ExecutorService executor = Executors.newFixedThreadPool(NUM_THREADS);

        IntStream.range(0, NUM_THREADS).forEach(num -> {
            DataCollector dataCollector = new DataCollector(UUID.randomUUID(), latch, salesDataList);
            executor.execute(dataCollector);
        });

        try {
            latch.await();
        } catch (InterruptedException e) {
            log.error(e.getMessage());
        }

        executor.shutdown();
        try {
            if (executor.awaitTermination(TERMINATION_DELAY, TimeUnit.SECONDS)) {
                ReportGenerator reportGenerator = new ReportGenerator(salesDataList);
                reportGenerator.generateReport();
                log.info("All tasks successfully completed");
            } else {
                log.error("Tasks are not completed");
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            log.error(e.getMessage());
        }
    }
}

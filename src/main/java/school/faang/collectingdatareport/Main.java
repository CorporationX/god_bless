package school.faang.collectingdatareport;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        int numberOfStores = 3;
        CountDownLatch latch = new CountDownLatch(numberOfStores);
        List<SalesData> salesDataList = new ArrayList<>();

        ExecutorService executor = Executors.newFixedThreadPool(numberOfStores);

        for (int i = 1; i <= numberOfStores; i++) {
            String storeId = "store-" + i;
            executor.submit(new DataCollector(storeId, latch, salesDataList));
        }

        latch.await();

        ReportGenerator reportGenerator = new ReportGenerator(salesDataList);
        reportGenerator.generateReport();

        executor.shutdown();
    }
}


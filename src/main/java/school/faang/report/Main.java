package school.faang.report;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        int storeCount = 3;
        CountDownLatch latch = new CountDownLatch(storeCount);
        List<salesdata> dataList = new ArrayList<>();

        ExecutorService executor = Executors.newFixedThreadPool(storeCount);

        for (int i = 0; i < storeCount; i++) {
            executor.submit(new DataCollector("Store " + (i+1), latch, dataList));
        }

        System.out.println("Collecting data...");

        latch.await();

        reportgenerator reportGen = new reportgenerator(dataList);
        reportGen.GenerateReport();
}
}



package faang.school.godbless.collectingDataReport;

import java.util.*;
import java.util.concurrent.CountDownLatch;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        int numStores = 3;

        CountDownLatch latch = new CountDownLatch(numStores);
        List<SalesData> salesDataList = new ArrayList<>();

        for (int i = 1; i <= numStores; i++) {
            SalesData salesData = new SalesData(i);
            salesDataList.add(salesData);

            DataCollector dataCollector = new DataCollector(salesData, latch);
            dataCollector.start();
        }

        latch.await();

        ReportGenerator reportGenerator = new ReportGenerator();
        reportGenerator.generateReport(salesDataList);
    }

}

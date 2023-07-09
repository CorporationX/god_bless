package faang.school;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;

public class Main {
    public static void main(String[] args) {
        int numStores = 4;
        CountDownLatch latch = new CountDownLatch(numStores);
        List<SalesData> allSalesData = new ArrayList<>();

        for (int i = 0; i < 4; i++) {
            SalesData salesData = new SalesData(i + 1, new ArrayList<>());
            for (int j = 1; j <= 5; j++) {
                Sale sale = new Sale(j + i, j * 10);
                salesData.getSales().add(sale);
            }
            Thread collectorThread = new DataCollector(latch, salesData);
            collectorThread.start();
            allSalesData.add(salesData);
        }

        try {
            latch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        ReportGenerator reportGenerator = new ReportGenerator();
        reportGenerator.generateReport(allSalesData);
    }
}

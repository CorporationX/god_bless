package faang.school.godbless.sprint4.report;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;

public class Main {
    public static void main(String[] args) {
        List<SalesData> salesDataList = new ArrayList<>();
        CountDownLatch latch = new CountDownLatch(2);

        DataCollector collector1 = new DataCollector(latch, 1);
        DataCollector collector2 = new DataCollector(latch, 2);

        collector1.start();
        collector2.start();

        try {
            latch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        salesDataList.add(collector1.getSalesData());
        salesDataList.add(collector2.getSalesData());

        ReportGenerator reportGenerator = new ReportGenerator(salesDataList);
        reportGenerator.generateReport();
    }

}

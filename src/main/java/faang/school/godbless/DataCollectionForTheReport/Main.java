package faang.school.godbless.DataCollectionForTheReport;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        CountDownLatch latch = new CountDownLatch(3);
        List<DataCollector> collectors = List.of(
                new DataCollector(latch, new SalesData(1)),
                new DataCollector(latch, new SalesData(2)),
                new DataCollector(latch, new SalesData(3))
        );

        collectors.forEach(DataCollector::start);

        latch.await();

        List<SalesData> salesDataList = new ArrayList<>();
        collectors.forEach(collector -> salesDataList.add(collector.getSalesData()));

        ReportGenerator reportGenerator = new ReportGenerator();
        reportGenerator.generateReport(salesDataList);
    }
}

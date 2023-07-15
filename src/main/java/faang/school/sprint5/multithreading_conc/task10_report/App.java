package faang.school.sprint5.multithreading_conc.task10_report;

import java.time.LocalDateTime;
import java.util.concurrent.CountDownLatch;

public class App {

    public static void main(String[] args) {
        CountDownLatch countDownLatch = new CountDownLatch(5);

        ReportGenerator reportGenerator = new ReportGenerator(countDownLatch);

        for (int i = 1; i <= 5; i++) {
            SalesData salesData = new SalesData(i);
            for (int j = 1; j <= 10; j++) {
                salesData.addSales(new Sales(j, LocalDateTime.now(), j * i));
            }
            DataCollector dataCollector = new DataCollector(countDownLatch, salesData);
            dataCollector.start();
            reportGenerator.addDataCollector(dataCollector);
        }

        reportGenerator.getReport();
    }
}

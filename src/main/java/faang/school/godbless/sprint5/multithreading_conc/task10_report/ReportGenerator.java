package faang.school.godbless.sprint5.multithreading_conc.task10_report;

import lombok.SneakyThrows;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;

public class ReportGenerator {

    private final List<DataCollector> dataCollector = new ArrayList<>();

    private final CountDownLatch countDownLatch;

    public ReportGenerator(CountDownLatch countDownLatch) {
        this.countDownLatch = countDownLatch;
    }

    public void addDataCollector(DataCollector dataCollector) {
        this.dataCollector.add(dataCollector);
    }

    @SneakyThrows
    public void getReport() {
        System.out.println("countDownLatch.await()");
        countDownLatch.await();
        System.out.println("Сбор отчета начался...");
        List<Sales> sales = new ArrayList<>();
        for (DataCollector dataCollector : dataCollector) {
            sales.addAll(dataCollector.fetchSalesFromStore());
        }
        sales.forEach(System.out::println);
        System.out.println("Сбор отчета закончился...");
    }
}

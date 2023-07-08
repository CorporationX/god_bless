package faang.school.sprint5.multithreading_conc.task10_report;

import lombok.SneakyThrows;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;

public class DataCollector extends Thread{

    private final SalesData salesData;

    private final CountDownLatch countDownLatch;

    private final List<Sales> allSales;

    public DataCollector(CountDownLatch countDownLatch, SalesData salesData) {
        this.salesData = salesData;
        this.countDownLatch = countDownLatch;
        this.allSales = new ArrayList<>();
    }

    @SneakyThrows
    @Override
    public void run() {
        System.out.println("Сбор данных начался...");
        allSales.addAll(salesData.getSales());
        Thread.sleep(1500);
        System.out.println("Сбор данных закончился...");
        countDownLatch.countDown();
    }

    @SneakyThrows
    public List<Sales> fetchSalesFromStore() {
        return allSales;
    }

}

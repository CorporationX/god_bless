package faang.school.godbless.collectingDataReport;

import java.time.LocalDateTime;
import java.util.concurrent.CountDownLatch;

public class DataCollector extends Thread{
    private final SalesData salesData;
    private final CountDownLatch latch;

    public DataCollector(SalesData salesData, CountDownLatch latch) {
        this.salesData = salesData;
        this.latch = latch;
    }

    @Override
    public void run() {
        fetchSalesFromStore();

        latch.countDown();
    }

    private void fetchSalesFromStore() {
        salesData.addSales(new Sales(1, LocalDateTime.now(), 10));
        salesData.addSales(new Sales(2, LocalDateTime.now(), 5));
        salesData.addSales(new Sales(3, LocalDateTime.now(), 28));
        salesData.addSales(new Sales(4, LocalDateTime.now(), 150));
    }

}

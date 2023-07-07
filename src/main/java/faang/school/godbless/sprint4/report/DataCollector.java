package faang.school.godbless.sprint4.report;


import java.util.concurrent.CountDownLatch;

public class DataCollector extends Thread{
    private CountDownLatch countDownLatch;
    private int storeId;
    private SalesData salesData;

    public DataCollector(CountDownLatch latch, int storeId) {
        this.countDownLatch = latch;
        this.storeId = storeId;
        this.salesData = new SalesData(storeId);
    }
    public SalesData getSalesData() {
        return salesData;
    }
    public void fetchSalesFromStore() {
        salesData.addSale(1, 20, 1);
    }
    @Override
    public void run() {
        fetchSalesFromStore();
        countDownLatch.countDown();
    }
}

package school.faang.report;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;

public class DataCollector implements Runnable {
    private final String storeId;
    private final CountDownLatch latch;
    private final List<SalesData> salesDataList;

    public DataCollector(String storeId, CountDownLatch latch, List<SalesData> salesDataList) {
        this.storeId = storeId;
        this.latch = latch;
        this.salesDataList = salesDataList;
    }

    private List<Sales> fetchSalesFromStore() {
        List<Sales> salesList = new ArrayList<>();
        salesList.add(new Sales("ProductA", System.currentTimeMillis(), 10));
        salesList.add(new Sales("ProductB", System.currentTimeMillis(), 5));
        return salesList;
    }

    @Override
    public void run() {
        try {
            List<Sales> sales = fetchSalesFromStore();
            SalesData salesData = new SalesData(storeId, sales);
            synchronized (salesDataList) {
                salesDataList.add(salesData);
            }
        } finally {
            latch.countDown();
        }
    }
}


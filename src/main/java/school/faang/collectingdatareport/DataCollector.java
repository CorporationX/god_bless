package school.faang.collectingdatareport;

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
        List<Sales> sales = new ArrayList<>();
        sales.add(new Sales("product-1", java.time.LocalDateTime.now(), 10));
        sales.add(new Sales("product-2", java.time.LocalDateTime.now(), 5));
        return sales;
    }

    @Override
    public void run() {
        try {
            List<Sales> sales = fetchSalesFromStore();
            synchronized (salesDataList) {
                salesDataList.add(new SalesData(storeId, sales));
            }
        } finally {
            latch.countDown();
        }
    }
}


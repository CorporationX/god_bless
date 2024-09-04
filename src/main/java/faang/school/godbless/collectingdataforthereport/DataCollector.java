package faang.school.godbless.collectingdataforthereport;

import java.util.List;
import java.util.concurrent.CountDownLatch;

public record DataCollector(Store store, List<SalesData> salesDataList, CountDownLatch latch) implements Runnable {

    @Override
    public void run() {
        List<Sales> sales = store.generateSalesData();
        synchronized (salesDataList) {
            salesDataList.add(new SalesData(store.getStoreId(), sales));
        }
        latch.countDown();
    }
}
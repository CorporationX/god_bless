package bjs2_62865;

import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;

@RequiredArgsConstructor
public class DataCollector implements Runnable {
    private final int storeId;
    private final CountDownLatch latch;
    private final List<SalesData> salesDataList;

    public List<Sales> fetchSalesFromStore() {
        return new ArrayList<>();
    }

    @Override
    public void run() {
        var sales = fetchSalesFromStore();
        var salesData = new SalesData(storeId, sales);

        synchronized (salesDataList) {
            salesDataList.add(salesData);
        }

        latch.countDown();
    }
}

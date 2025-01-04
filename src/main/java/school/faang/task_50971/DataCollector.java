package school.faang.task_50971;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.Collections;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.CountDownLatch;

@Slf4j
@RequiredArgsConstructor
public class DataCollector implements Runnable {
    private static final int DATA_COLLECTION_DELAY = 3000;

    private final UUID storeId;
    private final CountDownLatch latch;
    private final List<SalesData> salesDataList;

    private List<Sale> fetchSalesFromStore() {
        try {
            Thread.sleep(DATA_COLLECTION_DELAY);
        } catch (InterruptedException e) {
            log.error(e.getMessage());
        }
        return Collections.emptyList();
    }

    @Override
    public void run() {
        try {
            List<Sale> sales = fetchSalesFromStore();
            SalesData salesData = new SalesData(storeId, sales);
            synchronized (salesDataList) {
                salesDataList.add(salesData);
            }
        } finally {
            latch.countDown();
        }
    }
}

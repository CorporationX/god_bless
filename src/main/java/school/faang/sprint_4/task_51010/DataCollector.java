package school.faang.sprint_4.task_51010;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.locks.ReentrantLock;

@Slf4j
@RequiredArgsConstructor
public class DataCollector implements Runnable {
    private static final ReentrantLock  lock = new ReentrantLock();
    private final int storeId;
    private final CountDownLatch latch;
    private final List<SalesData> salesDataList;

    @Override
    public void run() {
        List<Sales> sales = fetchSalesFromStore();
        SalesData salesData =  new SalesData(storeId, sales);
        lock.lock();
        try {
            log.info("Данные для магазина №{} добавлены в список", salesData.storeId());
            salesDataList.add(salesData);
        } finally {
            latch.countDown();
            lock.unlock();
        }
    }

    public List<Sales> fetchSalesFromStore() {
        return new ArrayList<>(List.of(new Sales(1, LocalDateTime.now(), 10)));
    }

}

package school.faang.sprint_4.task_50951;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.concurrent.CountDownLatch;

@RequiredArgsConstructor
@Slf4j
public class DataCollector implements Runnable {
    private final int storeId;
    private final CountDownLatch latch;
    private final ReportGenerator reportGenerator;

    public List<Sales> fetchSalesFromStore() {
        return reportGenerator
                .getSalesDataByStoreId(storeId)
                .getSales();
    }

    @Override
    public void run() {
        System.out.println("Fetching data from store " + fetchSalesFromStore());
        latch.countDown();
        log.info("latch count: {}", latch.getCount());
    }
}

package faang.school.godbless.data_collection;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.time.LocalDateTime;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.IntStream;

@Slf4j
@RequiredArgsConstructor
public class DataCollector {
    private final int EXECUTION_TIME_LOWER_BOUND = 1000;
    private final int EXECUTION_TIME_UPPER_BOUND = 10000;

    private final int STORES_NUM;
    private final CountDownLatch countDownLatch;

    public void fetchSalesFromStoreToList(SalesData salesData) {
        IntStream.range(0, STORES_NUM)
                .forEach(i -> salesData.getSalesMap().put(i, new Sales(i, LocalDateTime.now(), i)));
        int sleepTime = ThreadLocalRandom.current().nextInt(EXECUTION_TIME_LOWER_BOUND, EXECUTION_TIME_UPPER_BOUND);
        try {
            Thread.sleep(sleepTime);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            log.warn("Fetching sales was interrupted");
        }
        log.info("Fetching sales was finished successfully");
        countDownLatch.countDown();
    }
}

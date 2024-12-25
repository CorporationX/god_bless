package school.faang.async_future;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class MasterCardService {
    public int collectPayment() {
        try {
            Thread.sleep(10_000);
            return 10_000;
        } catch (InterruptedException e) {
            log.error("Thread running was interrupted {}", Thread.currentThread().getName());
            throw new RuntimeException();
        }
    }

    public int sendAnalytics() {
        try {
            Thread.sleep(1_000);
            return 1_000;
        } catch (InterruptedException e) {
            log.error("Thread running was interrupted {}", Thread.currentThread().getName());
            throw new RuntimeException();
        }
    }
}

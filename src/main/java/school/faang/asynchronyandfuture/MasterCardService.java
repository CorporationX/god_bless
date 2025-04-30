package school.faang.asynchronyandfuture;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class MasterCardService {
    public int collectPayment() {
        try {
            Thread.sleep(10000);
            return 5_000;
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            log.error("Thread was interrupted while sleeping!", e);
            throw new RuntimeException("Thread was interrupted", e);
        }
    }

    public int sendAnalyze() {
        try {
            Thread.sleep(1000);
            return 17_000;
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            log.error("Thread was interrupted while sleeping!", e);
            throw new RuntimeException("Thread was interrupted", e);
        }
    }
}

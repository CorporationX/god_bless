package school.faang.asynchronyandfuture;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class MasterCardService {
    private static final int TEN_SECONDS = 10000;
    private static final int ONE_SECOND = 1000;

    public int collectPayment() {
        try {
            Thread.sleep(TEN_SECONDS);
            return 5_000;
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            log.error("Thread was interrupted while sleeping!", e);
            throw new RuntimeException("Thread was interrupted", e);
        }
    }

    public int sendAnalyze() {
        try {
            Thread.sleep(ONE_SECOND);
            return 17_000;
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            log.error("Thread was interrupted while sleeping!", e);
            throw new RuntimeException("Thread was interrupted", e);
        }
    }
}

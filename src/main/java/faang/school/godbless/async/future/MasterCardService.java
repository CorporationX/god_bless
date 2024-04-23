package faang.school.godbless.async.future;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class MasterCardService {

    public int collectPayment() {
        try {
            Thread.sleep(10_000);
            return 10_000;
        } catch (InterruptedException e) {
            log.error("Collecting payment was interrupted.", e);
            throw new RuntimeException();
        }
    }

    public int sendAnalytics() {
        try {
            Thread.sleep(1_000);
            return 1_000;
        } catch (InterruptedException e) {
            log.error("Sending analytics was interrupted.", e);
            throw new RuntimeException();
        }
    }
}

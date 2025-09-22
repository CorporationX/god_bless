package school.faang.bjs2_92534;

import lombok.extern.slf4j.Slf4j;

import java.util.Random;

@Slf4j
public class MasterCardService {
    private static final int TEN_SECONDS_IN_MS = 10_000;
    private static final int ONE_SECOND_IN_MS = 1_000;
    Random random = new Random();

    public int collectPayment() {
        sleepThread(TEN_SECONDS_IN_MS);
        return random.nextInt(Integer.MAX_VALUE);
    }

    public int sendAnalytics() {
        sleepThread(ONE_SECOND_IN_MS);
        return random.nextInt(Integer.MAX_VALUE);
    }

    public void doAll() {
        sleepThread(ONE_SECOND_IN_MS);
        log.info("что-то сделал и вывел какой результат");
    }

    private void sleepThread(int timeSleep) {
        try {
            Thread.sleep(timeSleep);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new RuntimeException(e);
        }
    }

}

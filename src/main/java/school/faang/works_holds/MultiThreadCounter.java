package school.faang.works_holds;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CountDownLatch;

@Getter
@Slf4j
public class MultiThreadCounter {
    public static final CountDownLatch countDownLatch = new CountDownLatch(Main.THREAD_COUNT);

    public static void awaitForOtherThread() {
        MultiThreadCounter.countDownLatch.countDown();
        while (MultiThreadCounter.countDownLatch.getCount() > 0) {
            log.debug("Waiting...");
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                log.error(e.getMessage(), e);
            }
        }
    }
}

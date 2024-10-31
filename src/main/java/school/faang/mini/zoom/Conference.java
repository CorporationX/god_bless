package school.faang.mini.zoom;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;

@Slf4j
public class Conference {
    private final int id;
    private final String subject;
    private final int requiredParticipants;
    private final CountDownLatch countDownLatch;
    private final CyclicBarrier cyclicBarrier;

    public Conference(int id, String subject, int requiredParticipants) {
        this.id = id;
        this.subject = subject;
        this.requiredParticipants = requiredParticipants;
        countDownLatch = new CountDownLatch(requiredParticipants);
        cyclicBarrier = new CyclicBarrier(requiredParticipants);
    }

    public void startStreaming() {
        try {
            countDownLatch.await();
            System.out.println("Трансляция началась " + subject);
        } catch (InterruptedException e) {
            log.error(e.getMessage(), e);
        }
    }

    public void join() {
        countDownLatch.countDown();
        try {
            cyclicBarrier.await();
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }
    }
}

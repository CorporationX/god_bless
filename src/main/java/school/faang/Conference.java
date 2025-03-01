package school.faang;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.atomic.AtomicInteger;

@Slf4j
@Getter
public class Conference {
    private final int requiredParticipants;
    private final CyclicBarrier barrier;
    private final AtomicInteger currentParticipants = new AtomicInteger(0);
    private volatile boolean isStarted = false;

    public Conference(int requiredParticipants) {
        this.requiredParticipants = requiredParticipants;
        barrier = new CyclicBarrier(requiredParticipants, this::startStreaming);
    }

    public void startStreaming() {
        if (!isStarted) {
            isStarted = true;
            log.info("Conference started.");
        }
    }

    public void join() {
        if (currentParticipants.get() >= requiredParticipants) {
            log.info("Conference already full. Participant cannot join.");
            return;
        }
        if (currentParticipants.incrementAndGet() <= requiredParticipants) {
            log.info("Participant attempting to join the conference.");
            try {
                barrier.await();
            } catch (InterruptedException | BrokenBarrierException e) {
                Thread.currentThread().interrupt();
                log.error("Barrier await interrupted in \"join\".");
                return;
            }
        }
        log.info("Participant joined the conference.");
    }
}

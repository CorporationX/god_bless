package faang.school.godbless.minizoom;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

@Slf4j
public class Conference {
    private final int requiredParticipants;
    private final CyclicBarrier barrier;

    public Conference(int requiredParticipants) {
        this.requiredParticipants = requiredParticipants;
        this.barrier = new CyclicBarrier(requiredParticipants, this::startStreaming);
    }

    public void addParticipant(Participant participant) {
        log.info("Participant {} has joined conference", participant.name());
        try {
            barrier.await();
        } catch (InterruptedException e) {
            log.error("Interrupted", e);
            Thread.currentThread().interrupt();
        } catch (BrokenBarrierException e) {
            throw new RuntimeException(e);
        }
    }

    private void startStreaming() {
        log.info("All participants joined. Conference started");
    }
}
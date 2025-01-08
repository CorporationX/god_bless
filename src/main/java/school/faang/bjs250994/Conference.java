package school.faang.bjs250994;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

@Slf4j
public class Conference {

    private final int requiredParticipants;
    private final CyclicBarrier barrier;

    public Conference(int requiredParticipants) {
        if (requiredParticipants <= 0) {
            log.error("Invalid number of required participants: {}", requiredParticipants);
            throw new IllegalArgumentException("Number of required participants must be greater than 0");
        }
        this.requiredParticipants = requiredParticipants;
        this.barrier = new CyclicBarrier(requiredParticipants, this::startStreaming);
        log.info("Conference initialized with {} required participants", requiredParticipants);
    }

    public void startStreaming() {
        log.info("All participants connected and streaming starts");
    }

    public void joinConference() {
        try {
            log.info("Participant attempting to join the conference");
            barrier.await();
        } catch (InterruptedException | BrokenBarrierException e) {
            log.error("Error while participant was attempting to join the conference", e);
            throw new RuntimeException(e);
        }
    }
}
package school.faang.minizoom;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

@Slf4j
public class Conference {
    private int requiredParticipants;
    private final CyclicBarrier barrier;


    public Conference(int requiredParticipants) {
        this.requiredParticipants = requiredParticipants;
        this.barrier = new CyclicBarrier(requiredParticipants, this::startStreaming);
    }

    public void startStreaming() {
        log.info("Все участники присоединились. Трансляция началась.");
    }

    public void join() {
        try {
            barrier.await();
        } catch (InterruptedException | BrokenBarrierException e) {
            log.error("Поток был прерван " + e.getMessage());
        }
    }
}

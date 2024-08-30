package faang.school.godbless.task.multithreading.concurrency.mini.zoom;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

@Slf4j
@Getter
public class Conference {
    private final long id;
    private final CyclicBarrier cyclicBarrier;

    public Conference(long id, int numberOfParticipants) {
        this.id = id;
        this.cyclicBarrier = new CyclicBarrier(numberOfParticipants, this::startConference);
    }

    public void join(Participant participant) {
        try {
            log.info("Participant id: {} waiting to start conference", participant.id());
            cyclicBarrier.await();
        } catch (InterruptedException | BrokenBarrierException e) {
            throw new RuntimeException(e);
        }
    }

    private void startConference() {
        log.info("Conference id: {} starting", this.id);
    }
}

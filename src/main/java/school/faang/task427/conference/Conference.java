package school.faang.task427.conference;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class Conference {
    private int requiredParticipants;
    private CyclicBarrier barrier;

    public Conference(int requiredParticipants) {
        this.requiredParticipants = requiredParticipants;
        barrier = new CyclicBarrier(requiredParticipants, this::startStreaming);
    }

    public void startStreaming() {
        System.out.println("Начало конференции");
    }

    public void join() {
        try {
            barrier.await();
        } catch (InterruptedException | BrokenBarrierException e) {
            throw new IllegalStateException(e.getStackTrace().toString());
        }
    }
}

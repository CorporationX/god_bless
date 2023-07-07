package faang.school.godbless.miniZoom;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class Conference {
    private final CyclicBarrier barrier;

    public Conference(int requiredParticipants) {
        this.barrier = new CyclicBarrier(requiredParticipants, this::startStreaming);
    }

    public void startStreaming() {
        System.out.println("Conference streaming has started!");
    }

    public void participantArrived() throws InterruptedException, BrokenBarrierException {
        barrier.await();
    }

}

package derschrank.sprint04.task21.bjstwo_50984;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class Conference {
    private final int requiredParticipants;
    private final CyclicBarrier barrier;

    public Conference(int requiredParticipants) {
        this.requiredParticipants = requiredParticipants;
        barrier = new CyclicBarrier(requiredParticipants, this::startConference);
    }

    public void join() {
        try {
            barrier.await();
        } catch (InterruptedException e) {
            System.out.println("InterruptedException " + e);
        } catch (BrokenBarrierException e) {
            System.out.println("BrokenBarrierException " + e);
        }
    }

    public void startConference() {
        System.out.printf("We have %d participants, so begin we conference%n", requiredParticipants);
    }
}

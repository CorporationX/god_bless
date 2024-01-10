package Concurrency_3;

import java.util.concurrent.CyclicBarrier;

public class Conference {

    CyclicBarrier barrier;

    public Conference(int count) {
        barrier = new CyclicBarrier(count, () -> System.out.println("start stream"));
    }

    public void addParticipant(Participant participant) {
        participant.joinConference(barrier);
    }

    public CyclicBarrier getBarrier() {
        return barrier;
    }
}

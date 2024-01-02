package faang.school.godbless.Zoom;

import lombok.Getter;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

@Getter
public class Conference {
    private final String name;
    private final int numberOfParticipantsRequired;
    private final CyclicBarrier barrier;

    public Conference(String name, int numberOfParticipantsRequired) {
        this.name = name;
        this.numberOfParticipantsRequired = numberOfParticipantsRequired;
        this.barrier = new CyclicBarrier(numberOfParticipantsRequired, () -> System.out.println("All participants joined"));
    }

    public void startStreaming() {
        try {
            System.out.println("Waiting for participants to join");
            barrier.await();
            System.out.println("Streaming started");
        } catch (InterruptedException | BrokenBarrierException e) {
            throw new RuntimeException(e);
        }
    }
}

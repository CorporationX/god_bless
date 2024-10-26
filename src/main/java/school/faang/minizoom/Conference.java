package school.faang.minizoom;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

@Getter
@RequiredArgsConstructor
public class Conference {
    private final int requiredParticipants;
    private final CyclicBarrier barrier = new CyclicBarrier(requiredParticipants, this::startStreaming);

    private void startStreaming() {
        System.out.println("Streaming has started! All participants are now connected.");
    }

    public void join() {
        try {
            barrier.await();
        } catch (InterruptedException | BrokenBarrierException e) {
            Thread.currentThread().interrupt();
            System.err.println("An error occurred while waiting for other participants.");
        }
    }
}

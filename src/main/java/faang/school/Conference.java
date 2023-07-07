package faang.school;

import lombok.AllArgsConstructor;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

@AllArgsConstructor
public class Conference {
    private final CyclicBarrier barrier;

    public void joinStream() {
        try {
            barrier.await();
        } catch (InterruptedException | BrokenBarrierException e) {
            throw new RuntimeException(e);
        }
        startStreaming();
    }

    public void startStreaming() {
        System.out.println("The stream is started");
    }

}

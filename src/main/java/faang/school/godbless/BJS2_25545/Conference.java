package faang.school.godbless.BJS2_25545;

import lombok.Getter;
import lombok.Setter;

import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

@Setter
@Getter
public class Conference {
    private static final int REQUIRED_PARTICIPANTS = 4;
    private CyclicBarrier barrier;

    public Conference() {
        this.barrier = new CyclicBarrier(REQUIRED_PARTICIPANTS, this::startStreaming);
    }

    public void startStreaming() {
        System.out.println("Streaming started...");
    }

    public void join(String name) {
        try {
            Thread.sleep(new Random().nextInt(10000));
            System.out.printf("Participant %s joined\n", name);
            barrier.await();
        } catch (InterruptedException | BrokenBarrierException e) {
            System.out.printf("%s was interrupted\n", Thread.currentThread().getName());
            Thread.currentThread().interrupt();
        }
    }
}
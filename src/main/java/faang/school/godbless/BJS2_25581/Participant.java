package faang.school.godbless.BJS2_25581;

import lombok.AllArgsConstructor;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ThreadLocalRandom;

@AllArgsConstructor
public class Participant {
    String name;
    CyclicBarrier barrier;

    public void joinConference() {
        try {
            Thread.sleep(ThreadLocalRandom.current().nextInt(5000, 10000));
            System.out.println(this.name + " waiting");
            barrier.await();
            System.out.println(this.name + " joined conference");
        } catch (InterruptedException | BrokenBarrierException e) {
            Thread.currentThread().interrupt();
            throw new RuntimeException(e);
        }
    }
}

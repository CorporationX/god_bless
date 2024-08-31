package mini.zoom;

import lombok.Getter;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

@Getter
public class Conference {
    public static final int MEMBERS = 2;

    private final long id = System.nanoTime();
    private final CyclicBarrier barrier;

    public Conference() {
        this.barrier = new CyclicBarrier(MEMBERS, this::startStreaming);
    }

    public void startStreaming() {
        System.out.println("Конференция началась: " + this.getId());
    }

    public void joinMember(String name) {
        try {
            Thread.sleep(5000);
            System.out.printf("Учасник %s присоединился\n", name);

            this.barrier.await();
        } catch (InterruptedException | BrokenBarrierException e) {
            throw new RuntimeException(e);
        }
    }
}

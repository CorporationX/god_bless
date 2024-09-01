package faang.school.godbless.MiniZoom;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class Conference {
    private String info;
    private int membersToStart;
    private CyclicBarrier barrier;

    public Conference(String info, int membersToStart, CyclicBarrier barrier) {
        this.info = info;
        this.membersToStart = membersToStart;
        this.barrier = barrier;
    }

    public void startStream() {
        try {
            barrier.await();
            System.out.println("ждём типов");
        } catch (InterruptedException | BrokenBarrierException e) {
            throw new RuntimeException(e);
        }
        System.out.println("начали крутой стрим");
    }
}

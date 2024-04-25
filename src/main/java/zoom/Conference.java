package zoom;

import lombok.Data;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

@Data
public class Conference {
    private static final int AMOUNT_FOR_START = 5;
    private static final CyclicBarrier BARRIER = new CyclicBarrier(AMOUNT_FOR_START);

    public void startStreaming() {
        try {
            BARRIER.await();
        } catch (InterruptedException | BrokenBarrierException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Conference start");
    }

    public CyclicBarrier getBarrier() {
        return BARRIER;
    }

}

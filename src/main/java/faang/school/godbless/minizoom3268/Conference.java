package faang.school.godbless.minizoom3268;

import lombok.Getter;
import lombok.Setter;

import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.atomic.AtomicInteger;

@Getter
public class Conference {
    private int minViewersQuantityToStart;
    @Setter private AtomicInteger currentViewersQuantity;
    private CyclicBarrier barrier;

    public Conference(int minViewersQuantityToStart) {
        this.minViewersQuantityToStart = minViewersQuantityToStart;
        this.currentViewersQuantity = new AtomicInteger(0);
        this.barrier = new CyclicBarrier(minViewersQuantityToStart);
    }

    public void startStreaming() {
        System.out.println("Stream has started");
    }
}

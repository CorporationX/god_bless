package faang.school.godbless.Sprint4Future.MiniZoom;

import lombok.Getter;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
@Getter
public class Conference {
    private int quantity;
    private CyclicBarrier cyclicBarrier;

    public Conference(int quantity) {
        this.quantity = quantity;
        cyclicBarrier = new CyclicBarrier(quantity, this::startStreaming);
    }

    public void startStreaming(){
        System.out.println("Stream is start");
    }
}

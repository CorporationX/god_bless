package faang.school.godbless.multi_con.task3zoom;

import lombok.Getter;

import java.util.concurrent.CyclicBarrier;

@Getter
public class Conference {
    private final int quantity;
    private final CyclicBarrier BARRIER;

    public Conference(int quantity) {
        this.quantity = quantity;
        this.BARRIER = new CyclicBarrier(quantity, this::startStreaming);
    }

    public void startStreaming() {
        System.out.println("-------------------------------------------");
        System.out.println("Трансляция началась");
    }


}

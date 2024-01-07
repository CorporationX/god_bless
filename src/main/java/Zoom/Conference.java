package Zoom;

import lombok.Getter;

import java.util.concurrent.CyclicBarrier;

@Getter
public class Conference {
    private final int members;
    private final CyclicBarrier cyclicBarrier;

    public Conference(int members) {
        this.members = members;
        this.cyclicBarrier = new CyclicBarrier(members, this::startStreaming);
    }

    public void startStreaming() {
        System.out.println("Трансляция началась!");
    }


}

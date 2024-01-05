package Zoom;

import java.util.concurrent.CyclicBarrier;

public class Conference {
    private final int NUMBER_OF_MEMBERS = 5;
    private final CyclicBarrier cyclicBarrier = new CyclicBarrier(NUMBER_OF_MEMBERS);

    public void startStreaming(){
        System.out.println("Трансляция началась!");
    }


}

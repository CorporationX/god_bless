package miniZoom_1379;

import lombok.Data;

import java.util.concurrent.CyclicBarrier;

@Data

public class Conference {

    private final int countParticipant;
    private final CyclicBarrier barrier;

    public Conference(int countParticipant) {
        this.countParticipant = countParticipant;
        this.barrier = new CyclicBarrier(countParticipant, this::startStreaming);
    }

    public void startStreaming() {
        System.out.println("Внимание! Трансляция началась!");
    }
}
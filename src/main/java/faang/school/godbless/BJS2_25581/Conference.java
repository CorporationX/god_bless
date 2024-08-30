package faang.school.godbless.BJS2_25581;

import lombok.Getter;

import java.util.concurrent.CyclicBarrier;

@Getter
public class Conference {
    private final int NUMS_PARTICIPANTS;
    private final CyclicBarrier barrier;

    public Conference(int NUMS_PARTICIPANTS) {
        this.NUMS_PARTICIPANTS = NUMS_PARTICIPANTS;
        this.barrier = new CyclicBarrier(NUMS_PARTICIPANTS, this::startStreaming);
    }

    public void startStreaming() {
        System.out.println("Broadcast started");
    }
}

package faang.school.godbless.mini_zoom;

import lombok.Getter;

import java.util.concurrent.CyclicBarrier;

@Getter
public class Conference {
    public CyclicBarrier barrier;
    private final int requiredParticipants;

    public Conference(int requiredParticipants) {
        this.requiredParticipants = requiredParticipants;
        this.barrier = new CyclicBarrier(requiredParticipants, this::startStreaming);
    }

    public void startStreaming() {
        System.out.println("Трансляция конференции");
    }

    public void participantArrived(int participantNumber) {
        System.out.println("Участник " + participantNumber + " присоединился к конференции");
    }
}

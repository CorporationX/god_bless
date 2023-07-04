package faang.school.godbless.sprint4.zoom;

import lombok.Data;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

@Data
public class Conference {
    private int requiredParticipants;
    private CyclicBarrier participantsBarrier;

    public Conference(int requiredParticipants) {
        this.requiredParticipants = requiredParticipants;
        this.participantsBarrier = new CyclicBarrier(requiredParticipants, this::startStreaming);
    }

    public void startStreaming() {
        System.out.println("Streaming has started!");
    }

    public void participantArrived() {
        System.out.println("Participant arrived!");
        try {
            participantsBarrier.await();
        } catch (InterruptedException | BrokenBarrierException e) {
            e.printStackTrace();
        }
    }
}
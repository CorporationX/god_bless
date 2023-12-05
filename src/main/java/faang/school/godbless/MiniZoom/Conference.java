package faang.school.godbless.MiniZoom;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

@Data
public class Conference {
    private final int members;
    private CyclicBarrier cyclicBarrier;

    public Conference(int members) {
        this.members = members;
        this.cyclicBarrier = new CyclicBarrier(members);
    }

    public void startStreaming(Participant participant) {
        System.out.println(participant.getName() + " joined to conference");

        try {
            cyclicBarrier.await();
        } catch (BrokenBarrierException | InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("Conference started");
    }
}

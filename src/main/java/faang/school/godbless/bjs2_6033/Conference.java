package faang.school.godbless.bjs2_6033;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

@Slf4j
@Getter
public class Conference {
    private final String name;
    private final int numOfMembers;
    private final CyclicBarrier cyclicBarrier;

    public Conference(String name, int numOfMembers) {
        this.name = name;
        this.numOfMembers = numOfMembers;
        cyclicBarrier = new CyclicBarrier(numOfMembers);
    }

    public void startStreaming() {
        try {
            cyclicBarrier.await();
        } catch (BrokenBarrierException | InterruptedException e) {
            log.error(e.getMessage());
        }
        log.info("Broadcast {} has started", name);
    }
}

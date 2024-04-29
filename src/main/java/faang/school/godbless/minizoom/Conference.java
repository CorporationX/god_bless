package faang.school.godbless.minizoom;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

@Slf4j
@Data
public class Conference {
    private final String name;

    private final int NUMBER_OF_MEMBERS = 5;
    private final CyclicBarrier barrier = new CyclicBarrier(NUMBER_OF_MEMBERS);

    public void startStreaming() {
        try {
            barrier.await();
        } catch (BrokenBarrierException | InterruptedException e) {
            log.error(e.getMessage());
        }

        log.info("Stream started...");
    }
}

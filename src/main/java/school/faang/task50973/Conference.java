package school.faang.task50973;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CyclicBarrier;

@Slf4j
@Getter
public class Conference {
    private final CyclicBarrier barrier;
    private volatile boolean isStarted;

    public Conference(int requiredParticipants) {
        this.barrier = new CyclicBarrier(requiredParticipants, this::startStreaming);
    }

    private void startStreaming() {
        if (!isStarted) {
            isStarted = true;
            log.info("Конференция началась");
        }
    }
}

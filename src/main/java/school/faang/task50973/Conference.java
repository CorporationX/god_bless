package school.faang.task50973;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CyclicBarrier;

@Slf4j
public class Conference {
    @Getter
    private final CyclicBarrier barrier;
    private boolean isStart;

    public Conference(int requiredParticipants) {
        this.barrier = new CyclicBarrier(requiredParticipants, this::startStreaming);
    }

    private void startStreaming() {
        if (!isStart) {
            isStart = true;
            log.info("Конференция началась");
        }
    }
}

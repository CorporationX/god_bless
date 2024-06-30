package faang.school.godbless.sprint2.zoom;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CountDownLatch;

/**
 * @author Evgenii Malkov
 */
@Slf4j
@Getter
public class Conference {
    private final int requiredParticipants;
    private final CountDownLatch latch;

    public Conference(int requiredParticipants) {
        this.requiredParticipants = requiredParticipants;
        this.latch = new CountDownLatch(requiredParticipants);
    }

    public void startStreaming() {
        log.info("Трансляция началась");
    }
}

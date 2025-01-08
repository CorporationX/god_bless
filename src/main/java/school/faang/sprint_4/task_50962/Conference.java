package school.faang.sprint_4.task_50962;

import lombok.Getter;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CountDownLatch;

@Slf4j
@Getter
@ToString
public class Conference {
    private final int id;
    private final int requiredParticipants;
    private final CountDownLatch countDownLatch;

    public Conference(int id, int requiredParticipants) {
        this.id = id;
        this.requiredParticipants = requiredParticipants;
        this.countDownLatch = new CountDownLatch(requiredParticipants);
    }

    public void startStreaming() {
        try {
            countDownLatch.await();
            log.info("Starting streaming...");
        } catch (InterruptedException e) {
            log.info("Starting streaming was interrupted");
        }
    }
}

package school.faang.task_51001;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.Phaser;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.stream.IntStream;

@Slf4j
public class Conference {
    private final Phaser phaser;
    private final AtomicBoolean streamingStarted = new AtomicBoolean(false);

    public Conference(int requiredParticipants) {
        this.phaser = new Phaser(1);
        IntStream.range(1, requiredParticipants)
                .forEach(num -> phaser.register());
    }

    public void join() {
        phaser.arriveAndAwaitAdvance();

        if (streamingStarted.compareAndSet(false, true)) {
            startStreaming();
        }

        phaser.arriveAndDeregister();
    }

    private void startStreaming() {
        log.info("All the participants are connected. The broadcast has started");
    }
}

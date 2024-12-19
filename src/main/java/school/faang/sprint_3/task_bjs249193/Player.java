package school.faang.sprint_3.task_bjs249193;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.atomic.AtomicInteger;

@Slf4j
public class Player {
    private final Object lock = new Object();
    private boolean isPlaying = true;
    @Getter
    private final AtomicInteger countThreads = new AtomicInteger();

    public void play() {
        synchronized (lock) {
            countThreads.incrementAndGet();
            if (isPlaying) {
                log.info("Music is already playing");
            } else {
                isPlaying = true;
                log.info("Music start play");
            }
        }
    }

    public void pause() {
        synchronized (lock) {
            countThreads.incrementAndGet();
            if (isPlaying) {
                isPlaying = false;
                log.info("Music paused");
            } else {
                log.info("Music is already paused");
            }
        }
    }

    public void skip() {
        synchronized (lock) {
            countThreads.incrementAndGet();
            log.info("Next track");
        }
    }

    public void previous() {
        synchronized (lock) {
            countThreads.incrementAndGet();
            log.info("Previous track");
        }
    }
}

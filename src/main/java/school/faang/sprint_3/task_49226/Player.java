package school.faang.sprint_3.task_49226;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Player {
    private final Object lock = new Object();
    @Getter
    private boolean isPlaying;

    public void play() {
        synchronized (lock) {
            isPlaying = true;
            log.info("Плеер играет");
        }
    }

    public void pause() {
        synchronized (lock) {
            isPlaying = false;
            log.info("Пауза");
        }
    }

    public void skip() {
        synchronized (lock) {
            log.info("Пропуск одной песни");
        }
    }

    public void previous() {
        synchronized (lock) {
            log.info("Включается предедущая композиция");
        }
    }
}

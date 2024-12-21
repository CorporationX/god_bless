package school.faang.task_49259;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

import static school.faang.task_49259.PlayerStatus.*;

@Slf4j
public class Player {
    public static long MILLISECOND_IN_SEC = 1000;
    public static long SLEEP_TIME_SEC = 3;
    private PlayerStatus status = DO_NOTHING;
    private final Object lock = new Object();

    public void play() {
        synchronized (lock) {
            status = PLAY_MUSIC;
            log.info("Player status = {} ", status);
            sleepSec(SLEEP_TIME_SEC);
        }
    }

    public void pause() {
        synchronized (lock) {
            status = PAUSED;
            log.info("Player status = {} ", status);
            sleepSec(SLEEP_TIME_SEC);
        }
    }

    public void skip() {
        synchronized (lock) {
            status = SKIPPED;
            log.info("Player status = {} ", status);
            sleepSec(SLEEP_TIME_SEC);
        }
    }

    public void previous() {
        synchronized (lock) {
            status = SET_PREVIOUS_MUSIC;
            log.info("Player status = {} ", status);
            sleepSec(SLEEP_TIME_SEC);
        }
    }

    private void sleepSec(long sec) {
        try {
            Thread.sleep(sec * MILLISECOND_IN_SEC);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

package school.faang.task_49259;

import lombok.extern.slf4j.Slf4j;

import static school.faang.task_49259.PlayerStatus.*;

@Slf4j
public class Player {
    public static long MILLISECOND_IN_SEC = 1000;
    public static long SLEEP_TIME_SEC = 3;

    private PlayerStatus status = DO_NOTHING;
    private final Object lock = new Object();
    private boolean isPlaying = false;

    public void play() {
        synchronized (lock) {
            setIsPlayingOn();
            status = PLAY_MUSIC;
            log.info("Player status = {} ", status);
            sleepSec(SLEEP_TIME_SEC);
        }
    }

    public void pause() {
        synchronized (lock) {
            setIsPlayingOff();
            status = PAUSED;
            log.info("Player status = {} ", status);
            sleepSec(SLEEP_TIME_SEC);
        }
    }

    public void skip() {
        synchronized (lock) {
            setIsPlayingOn();
            status = SKIPPED;
            log.info("Player status = {} ", status);
            sleepSec(SLEEP_TIME_SEC);
        }
    }

    public void previous() {
        synchronized (lock) {
            setIsPlayingOn();
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

    private void setIsPlayingOn() {
        if (!isPlaying) {
            isPlaying = true;
            log.info("Музыка воспроизводится.");
        } else {
            log.info("Музыка уже играет.");
        }
    }

    private void setIsPlayingOff() {
        if (isPlaying) {
            isPlaying = false;
            log.info("Музыка поставлена на паузу.");
        } else {
            log.info("Музыка уже на паузе.");
        }
    }
}

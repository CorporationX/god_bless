package school.faang.multithreading.synchronization.bjs2_73252.spotify;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
public class Player {
    private static boolean isPlaying;
    private static final Object lock = new Object();

    public static void play() {
        synchronized (lock) {
            if (isPlaying) {
                log.info("Player is already playing");
            } else {
                isPlaying = true;
                log.info("Player is turning on");
            }
        }
    }

    public static void pause() {
        synchronized (lock) {
            if (!isPlaying) {
                log.info("Player is not playing");
            } else {
                isPlaying = false;
                log.info("Player is turning off");
            }
        }
    }

    public static void skip() {
        synchronized (lock) {
            log.info("Song is skipped");
        }
    }

    public static void previous() {
        synchronized (lock) {
            log.info("Previous song");
        }
    }
}

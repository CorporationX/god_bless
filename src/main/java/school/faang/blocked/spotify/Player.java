package school.faang.blocked.spotify;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Player {
    private final Object lock = new Object();
    private static boolean isPlaying;

    public void play() {
        synchronized (lock) {
            if (!isPlaying) {
                isPlaying = true;
                log.info("музыка воспроизводится");
            } else {
                log.info("музыка уже играет");
            }
        }
    }

    public void pause() {
        synchronized (lock) {
            if (isPlaying) {
                isPlaying = false;
                log.info("музыка поставлена пауза");
            } else {
                log.info("музыка уже на паузе");
            }
        }
    }

    public void skip() {
        synchronized (lock) {
            log.info("трек пропущен");
        }
    }

    public void previous() {
        synchronized (lock) {
            log.info("включена предыдущая песня");
        }
    }
}

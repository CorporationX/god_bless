package school.faang.bjs2_81764;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Player {
    private final Object lock = new Object();
    private boolean isPlaying;

    public void play() {
        synchronized (lock) {
            if (!isPlaying) {
                isPlaying = true;
                log.info("музыка играет");
            } else {
                log.info("уже играет");
            }
        }
    }

    public void pause() {
        synchronized (lock) {
            if (isPlaying) {
                isPlaying = false;
                log.info("на паузе");
            } else {
                log.info("музыка как бы стоит ждет");
            }
        }
    }

    public void skip() {
        synchronized (lock) {
            log.info("переключение на след трек");
        }
    }

    public void previous() {
        synchronized (lock) {
            log.info("переключение на прошлый трек");
        }
    }
}

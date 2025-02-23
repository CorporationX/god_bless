package school.faang.task_61904;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Player {

    private final Object lock = new Object();
    private boolean isPlaying;

    public void play() {
        synchronized (lock) {
            if (!isPlaying) {
                isPlaying = true;
                log.info("Музыка начала воспроизводиться");
            } else {
                log.info("Музыка уже играет");
            }
        }
    }

    public void pause() {
        synchronized (lock) {
            if (isPlaying) {
                isPlaying = false;
                log.info("Музыка на паузе");
            } else {
                log.info("Музыка уже на паузе");
            }
        }
    }

    public void skip() {
        synchronized (lock) {
            log.info("Трек пропущен");
        }
    }

    public void previous() {
        synchronized (lock) {
            log.info("Переключение на предыдущий трек");
        }
    }
}

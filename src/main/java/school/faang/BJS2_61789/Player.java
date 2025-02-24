package school.faang.BJS2_61789;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Player {

    private final Object lock = new Object();
    private boolean isPlaying = false;

    public void play() {
        synchronized (lock) {
            if (!isPlaying) {
                isPlaying = true;
                log.info("Музыка начала играть");
            } else {
                log.info("Музыка уже играет");
            }
        }
    }

    public void pause() {
        synchronized (lock) {
            if (isPlaying) {
                isPlaying = false;
                log.info("Музыку поставили на паузу");
            } else {
                log.info("Музыка уже стоит на паузе");
            }
        }
    }

    public void skip() {
        synchronized (lock) {
            log.info("Переключиться на следующий трек");
        }
    }

    public void previous() {
        synchronized (lock) {
            log.info("Переключится на предыдущий трек");
        }
    }
}

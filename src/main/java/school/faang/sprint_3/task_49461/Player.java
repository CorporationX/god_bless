package school.faang.sprint_3.task_49461;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Player {
    private final Object lock = new Object();
    boolean isPlaying;

    public void play() {
        synchronized (lock) {
            if (isPlaying) {
                log.info("Музыка уже играет");
            } else {
                isPlaying = true;
                log.info("Начато воспроизведение музыки");
            }
        }
    }

    public void pause() {
        synchronized (lock) {
            if (isPlaying) {
                log.info("Музыка поставлена на паузу");
                isPlaying = false;
            } else {
                log.info("Музыка уже на паузе");
            }
        }
    }

    public void skip() {
        synchronized (lock) {
            log.info("Начат следующий трек");
        }
    }

    public void previous() {
        synchronized (lock) {
            log.info("Возвращен предыдущий трек");
        }
    }
}

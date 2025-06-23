package school.faang.bjs281795;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Player {
    private boolean isPlaying = false;
    private final Object lock = new Object();

    public void play() {
        synchronized (lock) {
            if (!isPlaying) {
                isPlaying = true;
                log.info("Проигрыватель запущен");
            } else {
                log.info("Плеер и так запущен");
            }
        }
    }

    public void pause() {
        synchronized (lock) {
            if (isPlaying) {
                isPlaying = false;
                log.info("Плеер остановлен");
            } else {
                log.info("Музыка и так не играет");
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
            log.info("Переход на предыдущий трек");
        }
    }
}

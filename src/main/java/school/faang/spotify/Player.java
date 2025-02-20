package school.faang.spotify;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Player {

    private boolean isPlaying;

    public synchronized void play() {
        if (!isPlaying) {
            isPlaying = true;
            log.info("Включил музыку! Танцуем!");
        } else {
            log.info("Музыка уже воспроизводится");
        }
    }

    public synchronized void pause() {
        if (isPlaying) {
            isPlaying = false;
            log.info("Остановил воспроизведение");
        } else {
            log.info("Музыка уже на паузе");
        }
    }

    public synchronized void skip() {
        log.info("Запускаю следующий трек");
    }

    public void previous() {
        log.info("Запускаю предыдущий трек");
    }
}

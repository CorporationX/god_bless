package school.faang.musicplayer;


import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Player {
    private Object lock = new Object();
    private boolean isPlaying;

    public void play() {
        synchronized (lock) {
            if (!isPlaying) {
                isPlaying = true;
                log.info("Старт проигрывания трека");
            } else {
                log.info("Трек уже играет");
            }
        }
    }

    public void pause() {
        synchronized (lock) {
            if (isPlaying) {
                isPlaying = false;
                log.info("Трек поставлен на паузу");
            } else {
                log.info("Трек уже на паузе");
            }
        }
    }

    public void skip() {
        synchronized (lock) {
            log.info("Следующий трек");
        }
    }

    public void previous() {
        synchronized (lock) {
            log.info("Предыдущий трек");
        }
    }
}

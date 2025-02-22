package school.faang.spotifyblocking;


import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Player {
    private boolean isPlaying;
    private final Object lock = new Object();

    public void play() {
        synchronized (lock) {
            if (!isPlaying) {
                isPlaying = true;
                log.info("Музыка воспроизводится!");
            } else {
                log.info("Музыка уже играет!");
            }
        }
    }

    public void pause() {

        synchronized (lock) {
            if (isPlaying) {
                isPlaying = false;
                log.info("Музыка остановлена");
            } else {
                log.info("Музыка уже на паузе");
            }
        }
    }

    public void skip() {
        synchronized (lock) {
            log.info("Трек пропущен.");
        }
    }

    public void previous() {
        synchronized (lock) {
            log.info("Вернулись к передыдущему треку");
        }
    }
}

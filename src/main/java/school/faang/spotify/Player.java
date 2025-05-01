package school.faang.spotify;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;


@Getter
@Setter
@Slf4j
public class Player {

    private final Object lock = new Object();
    private Boolean isPlaying = false;

    public void play() {
        synchronized (lock) {
            if (!isPlaying) {
                isPlaying = true;
                log.info("снял музыку с паузы");
            } else {
                log.info("музыка уже играет");
            }
        }
    }

    public void pause() {
        synchronized (lock) {
            if (isPlaying) {
                isPlaying = false;
                log.info("поставил музыку на паузу");
            } else {
                log.info("музыка уже стоит на паузе");
            }
        }
    }

    public void skip() {
        synchronized (lock) {
            log.info("включил следующий трек");
        }
    }

    public void previous() {
        synchronized (lock) {
            log.info("включил предыдущий трек");
        }
    }
}
package school.faang.spotify;

import lombok.Getter;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Getter
@ToString
public class Player {
    private final Object lock = new Object();
    private StatusPlayer isPlaying;

    public void play() {
        synchronized (lock) {
            log.info("PLAY");
            isPlaying = StatusPlayer.PLAY;
            log.info("Статус после нажатия PLAY: {}", this.getIsPlaying());
        }
    }

    public void pause() {
        synchronized (lock) {
            log.info("PAUSE");
            isPlaying = StatusPlayer.PAUSE;
            log.info("Статус после нажатия PAUSE: {}", this.getIsPlaying());
        }
    }

    public void skip() {
        synchronized (lock) {
            log.info("SKIP");
            isPlaying = StatusPlayer.PLAY;
            log.info("Статус после нажатия SKIP: {}", this.getIsPlaying());
        }
    }

    public void previous() {
        synchronized (lock) {
            log.info("PREVIOUS");
            isPlaying = StatusPlayer.PLAY;
            log.info("Статус после нажатия PREVIOUS: {}", this.getIsPlaying());
        }
    }
}

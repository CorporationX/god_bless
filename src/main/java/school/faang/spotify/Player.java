package school.faang.spotify;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Player {
    private final Object lock = new Object();
    @Getter
    private static String isPlaying;

    public void setIsPlaying(String isPlaying) {
        Player.isPlaying = isPlaying;
    }

    public void play() {
        synchronized (lock) {
            log.info("PLAY");
            this.setIsPlaying("Status: PLAY");
            log.info(Player.getIsPlaying());
        }
    }

    public void pause() {
        synchronized (lock) {
            log.info("PAUSE");
            this.setIsPlaying("Status: PAUSE");
            log.info(Player.getIsPlaying());
        }
    }

    public void skip() {
        synchronized (lock) {
            log.info("SKIP");
            this.setIsPlaying("Status: SKIP");
            log.info(Player.getIsPlaying());
        }
    }

    public void previous() {
        synchronized (lock) {
            log.info("PREVIOUS");
            this.setIsPlaying("Status: PREVIOUS");
            log.info(Player.getIsPlaying());
        }
    }
}

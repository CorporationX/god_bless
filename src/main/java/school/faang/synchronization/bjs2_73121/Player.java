package school.faang.synchronization.bjs2_73121;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

@Slf4j
class Player {
    private final List<String> playList = new ArrayList<>();
    private static boolean isPlaying;

    public void play() {
        synchronized (playList) {
            if (!isPlaying) {
                isPlaying = true;
                log.info("Музыка воспроизводится. isPlaying: {}", isPlaying);
            } else {
                log.info("Музыка уже играет.");
            }
        }
    }

    public void pause() {
        synchronized (playList) {
            if (isPlaying) {
                isPlaying = false;
                log.info("paused. isPlaying: {}", isPlaying);
            } else {
                log.info("Музыка уже на паузе.");
            }
        }
    }

    public void skip() {
        synchronized (playList) {
            isPlaying = true;
            log.info("song skipped. isPlaying: {}", isPlaying);
        }
    }

    public void previous() {
        synchronized (playList) {
            log.info("previous song. isPlaying: {}", isPlaying);
        }
    }
}

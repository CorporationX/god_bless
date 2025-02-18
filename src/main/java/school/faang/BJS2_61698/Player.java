package school.faang.BJS2_61698;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Player {
    private static final Logger logger = LoggerFactory.getLogger(Player.class);
    private final Object lock = new Object();
    private boolean isPlaying;

    private void executeSynchronized(Runnable action) {
        synchronized (lock) {
            action.run();
        }
    }

    public void play() {
        executeSynchronized(() -> {
            logger.info(!isPlaying ? "Музыка воспроизводится" : "Музыка уже играет");
            isPlaying = true;
        });
    }

    public void pause() {
        executeSynchronized(() -> {
            logger.info(isPlaying ? "Музыка поставлена на паузу" : "Музыка уже на паузе");
            isPlaying = false;
        });
    }

    public void skip() {
        executeSynchronized(() -> logger.info("Трек пропущен"));
    }

    public void previous() {
        executeSynchronized(() -> logger.info("К предыдущему треку."));
    }
}
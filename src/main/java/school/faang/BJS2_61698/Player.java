package school.faang.BJS2_61698;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Player {
    private final Object lock = new Object();
    private boolean isPlaying;

    private void executeSynchronized(Runnable action) {
        synchronized (lock) {
            action.run();
        }
    }

    public void play() {
        executeSynchronized(() -> {
            log.info(!isPlaying ? "Музыка воспроизводится" : "Музыка уже играет");
            isPlaying = true;
        });
    }

    public void pause() {
        executeSynchronized(() -> {
            log.info(isPlaying ? "Музыка поставлена на паузу" : "Музыка уже на паузе");
            isPlaying = false;
        });
    }

    public void skip() {
        executeSynchronized(() -> log.info("Трек пропущен"));
    }

    public void previous() {
        executeSynchronized(() -> log.info("К предыдущему треку."));
    }
}
package school.faang.task_49162;

import lombok.Getter;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Getter
public class Player {
    private static final int FIVE_SECOND = 5000;
    private boolean isPlaying;

    @SneakyThrows
    public void play() {
        synchronized (this) {
            isPlaying = true;
            log.info("Play music...");
            Thread.sleep(FIVE_SECOND);
        }
    }

    @SneakyThrows
    public void pause() {
        synchronized (this) {
            isPlaying = false;
            log.info("Pause music...");
            Thread.sleep(FIVE_SECOND);
        }
    }

    @SneakyThrows
    public void skip() {
        synchronized (this) {
            isPlaying = true;
            log.info("Skip track...");
            Thread.sleep(FIVE_SECOND);
        }
    }

    @SneakyThrows
    public void previous() {
        synchronized (this) {
            isPlaying = true;
            log.info("Play previous track...");
            Thread.sleep(FIVE_SECOND);
        }
    }
}

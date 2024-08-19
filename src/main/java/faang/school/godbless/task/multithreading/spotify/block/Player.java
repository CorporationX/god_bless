package faang.school.godbless.task.multithreading.spotify.block;

import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RequiredArgsConstructor
public class Player {
    private final Logger logger = LoggerFactory.getLogger(Player.class);
    private final Lock lock;
    private String isPlaying;

    public void play() {
        synchronized (lock) {
            isPlaying = "playing";
            logger.info("Поток {} запустил плеер: {}", Thread.currentThread().getName(), isPlaying);
        }
    }

    public void pause() {
        synchronized (lock) {
            isPlaying = "pause";
            logger.info("Поток {} поставил плеер на паузу: {}", Thread.currentThread().getName(), isPlaying);
        }
    }

    public void skip() {
        synchronized (lock) {
            isPlaying = "skip";
            logger.info("Поток {} переключил плеер вперед: {}", Thread.currentThread().getName(), isPlaying);
        }
    }

    public void previous() {
        synchronized (lock) {
            isPlaying = "previous";
            logger.info("Поток {} переключил плеер назад: {}", Thread.currentThread().getName(), isPlaying);
        }
    }
}

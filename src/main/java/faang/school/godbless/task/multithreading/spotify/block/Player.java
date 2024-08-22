package faang.school.godbless.task.multithreading.spotify.block;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Player {
    private final Lock lock = new Lock();
    private String isPlaying;

    public void play() {
        synchronized (lock) {
            isPlaying = "playing";
            log.info("Поток {} запустил плеер: {}", Thread.currentThread().getName(), isPlaying);
        }
    }

    public void pause() {
        synchronized (lock) {
            isPlaying = "pause";
            log.info("Поток {} поставил плеер на паузу: {}", Thread.currentThread().getName(), isPlaying);
        }
    }

    public void skip() {
        synchronized (lock) {
            isPlaying = "skip";
            log.info("Поток {} переключил плеер вперед: {}", Thread.currentThread().getName(), isPlaying);
        }
    }

    public void previous() {
        synchronized (lock) {
            isPlaying = "previous";
            log.info("Поток {} переключил плеер назад: {}", Thread.currentThread().getName(), isPlaying);
        }
    }
}

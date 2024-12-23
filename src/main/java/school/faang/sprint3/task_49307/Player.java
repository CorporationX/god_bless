package school.faang.sprint3.task_49307;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
public class Player {
    private boolean isPlaying = false;
    private int song;

    public synchronized void play() {
        isPlaying = true;
        log.info(Thread.currentThread().getName() + "| song is playing " + song);
    }

    public synchronized void pause() {
        isPlaying = false;
        log.info(Thread.currentThread().getName() + "| song is paused " + song);
    }

    public synchronized void skip() {
        song++;
        log.info(Thread.currentThread().getName() + "| current song is skipped " + song);
    }

    public synchronized void previous() {
        song--;
        log.info(Thread.currentThread().getName() + "| switched to previous song " + song);
    }
}

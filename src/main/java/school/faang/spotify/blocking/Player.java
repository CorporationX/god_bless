package school.faang.spotify.blocking;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;

@Slf4j
public class Player {
    private final Object lock = new Object();
    private boolean isPlaying;

    public void play() {
        synchronized (lock) {
            isPlaying = true;
            System.out.println("Воспроизводим трек");
            try {
                Thread.sleep(3_000);
            } catch (InterruptedException e) {
                log.error(e.getMessage());
                log.error(Arrays.toString(e.getStackTrace()));
            }
        }
    }

    public void pause() {
        synchronized (lock) {
            isPlaying = false;
            System.out.println("Ставим трек на паузу");
        }
    }

    public void skip() {
        synchronized (lock) {
            System.out.println("Переключаем на следующий трек");
        }
    }

    public void previous() {
        synchronized (lock) {
            System.out.println("Переключаем на предыдущий трек");
        }
    }
}

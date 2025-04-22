package school.faang.stream3.spotifylock;

import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Player {
    private final Object lock = new Object();
    @Setter
    private boolean isPlaying = false;

    public void play() {
        synchronized (lock) {
            System.out.printf("%s pressing Play, currently player is playing: %b\n",
                    Thread.currentThread().getName(), isPlaying);
            setPlaying(true);
        }
        delay();
    }

    public void pause() {
        synchronized (lock) {
            System.out.printf("%s pressing Pause, currently player is playing: %b\n",
                    Thread.currentThread().getName(), isPlaying);
            setPlaying(false);
        }
        delay();
    }

    public void skip() {
        synchronized (lock) {
            System.out.printf("%s pressing Skip, currently player is playing: %b\n",
                    Thread.currentThread().getName(), isPlaying);
        }
        delay();
    }

    public void previous() {
        synchronized (lock) {
            System.out.printf("%s pressing Previous, currently player is playing: %b\n",
                    Thread.currentThread().getName(), isPlaying);
        }
        delay();
    }

    private void delay() {
        try {
            Thread.sleep(50);
        } catch (InterruptedException e) {
            log.error("Interruption during delay");
        }
    }
}

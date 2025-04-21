package school.faang.stream3.spotifylock;

import lombok.Setter;
import lombok.SneakyThrows;

public class Player {
    private final String lock = "";
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

    @SneakyThrows
    private void delay() {
        Thread.sleep(50);
    }
}

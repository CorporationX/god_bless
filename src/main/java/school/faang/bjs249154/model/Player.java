package school.faang.bjs249154.model;

import lombok.AllArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@ToString
public class Player {
    @ToString.Exclude
    private final Object lock = new Object();
    private boolean isPlaying;
    private int currentSong;

    public void play() {
        synchronized (lock) {
            isPlaying = true;
        }
    }

    public void pause() {
        synchronized (lock) {
            isPlaying = false;
        }
    }

    public void skip() {
        synchronized (lock) {
            pause();
            currentSong++;
            play();
        }
    }

    public void previous() {
        synchronized (lock) {
            pause();
            currentSong--;
            play();
        }
    }
}

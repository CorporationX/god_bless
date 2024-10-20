package school.faang.BJS237155;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Player {
    private final Object lock = new Object();
    private boolean isPlaying;

    public void play() {
        synchronized (lock) {
            if (isPlaying) {
                System.out.println("The music has already started!");
            } else {
                System.out.println("Music start!");
            }
        }
    }

    public void pause() {
        synchronized (lock) {
            if (!isPlaying) {
                System.out.println("The music has already stopped!");
            } else {
                System.out.println("Music stop!");
            }
        }
    }

    public void skip() {
        synchronized (lock) {
            System.out.println("Skip the track!");
        }
    }

    public void previous() {
        synchronized (lock) {
            System.out.println("Return to previous track!");
        }
    }

}

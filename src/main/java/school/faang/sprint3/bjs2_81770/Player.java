package school.faang.sprint3.bjs2_81770;

import lombok.Getter;
import lombok.NoArgsConstructor;


@NoArgsConstructor
public class Player {
    private final Object lock = new Object();
    @Getter
    private boolean isPlaying = false;

    public void play() {
        synchronized (lock) {
            if (!isPlaying) {
                isPlaying = true;
                System.out.println("Is playing");
            } else {
                System.out.println("Already playing");
            }
        }
    }

    public void pause() {
        synchronized (lock) {
            if (isPlaying) {
                isPlaying = false;
                System.out.println("Is paused");
            } else {
                System.out.println("Already paused");
            }
        }
    }

    public void skip() {
        synchronized (lock) {
            System.out.println("Skip music");
        }
    }

    public void previous() {
        synchronized (lock) {
            System.out.println("Move to previous music");
        }
    }
}
package faang.school.godbless.BJS2_12762;

import lombok.Data;

@Data
public class Player {
    private final Object lock = new Object();
    private boolean isPlaying;
    private int songNumber;

    public void play() {
        synchronized (lock) {
            if (!isPlaying) {
                isPlaying = true;
                System.out.println("Play!");
            }
        }
    }

    public void pause() {
        synchronized (lock) {
            if (isPlaying) {
                isPlaying = false;
                System.out.println("Pause!");
            }
        }
    }

    public void skip() {
        synchronized (lock) {
            songNumber++;
            System.out.println("Song number " + songNumber);
        }
    }

    public void previous() {
        synchronized (lock) {
            songNumber--;
            System.out.println("Song number " + songNumber);
        }
    }
}

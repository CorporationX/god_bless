package faang.school.godbless;

import lombok.Getter;

@Getter
public class Player {
    private final Object object = new Object();
    private boolean isPlaying;

    public void play() {
        synchronized (object) {
            isPlaying = true;
            System.out.println("Music playing...");
        }
    }

    public void pause() {
        synchronized (object) {
            isPlaying = false;
            System.out.println("Music stopped");
        }
    }

    public void skip() {
        synchronized (object) {
            isPlaying = false;
            System.out.println("Music skipped");
        }
    }

    public void previous() {
        synchronized (object) {
            isPlaying = false;
            System.out.println("Music switched at previous");
        }
    }
}

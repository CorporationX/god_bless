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
            System.out.println("Is music paying: " + isPlaying());
        }
    }

    public void pause() {
        synchronized (object) {
            isPlaying = false;
            System.out.println("Music stopped");
            System.out.println("Is music paying: " + isPlaying());
        }
    }

    public void skip() {
        synchronized (object) {
            isPlaying = false;
            System.out.println("Music skipped");
            System.out.println("Is music paying: " + isPlaying());
        }
    }

    public void previous() {
        synchronized (object) {
            isPlaying = false;
            System.out.println("Music switched at previous");
            System.out.println("Is music paying: " + isPlaying());
        }
    }
}

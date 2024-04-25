package faang.school.godbless.spotify;

public class Player {

    private final Object lock = new Object();
    boolean isPlaying;

    public void play() {
        synchronized (lock) {
            if (!isPlaying) {
                this.isPlaying = true;
                System.out.println("Player play music");
            } else {
                System.out.println("The music is already playing");
            }
        }
    }

    public void pause() {
        synchronized (lock) {
            if (isPlaying) {
                isPlaying = false;
                System.out.println("The player is stopped");
            } else {
                System.out.println("The player does not play");
            }
        }
    }

    public void skip() {
        synchronized (lock) {
            if (isPlaying) {
                isPlaying = false;
                System.out.println("Skipping track");
                play();
            } else {
                System.out.println("The player is stopped");
            }
        }
    }

    public void previous() {
        synchronized (lock) {
            if (isPlaying) {
                isPlaying = false;
                System.out.println("Return previous track");
                play();
            } else {
                System.out.println("The player is stopped");
            }
        }
    }
}

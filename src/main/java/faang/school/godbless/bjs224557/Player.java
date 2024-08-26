package faang.school.godbless.bjs224557;

public class Player {
    private boolean isPlaying = false;
    private final Object lock = new Object();

    public void play() {
        synchronized (lock) {
            if(!isPlaying) {
                isPlaying = true;
                System.out.println("Playing music");
            } else {
                System.out.println("Music is already playing.");
            }
        }
    }

    public void pause() {
        synchronized (lock) {
            if(isPlaying) {
                isPlaying = false;
                System.out.println("Music paused");
            } else {
                System.out.println("Music is already paused");
            }
        }
    }

    public void skip() {
        synchronized (lock) {
            System.out.println("Skipping to the next track");

        }
    }

    public void previous() {
        synchronized (lock) {
            System.out.println("Going back to the previous track");
        }
    }
}

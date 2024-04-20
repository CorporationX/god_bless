package faang.school.godbless.BJS2_5819;

public class Player {
    private final Object LOCK = new Object();
    private Boolean isPlaying = false;

    public void play() {
        synchronized (LOCK) {
            if (isPlaying) {
                System.out.println("the music was played");
            } else {
                isPlaying = true;
                System.out.println("the music is playing");
            }
        }
    }

    public void pause() {
        synchronized (LOCK) {
            if (isPlaying) {
                System.out.println("the music is stop");
            } else {
                isPlaying = true;
                System.out.println("the music was stopped");
            }
        }
    }

    public void skip() {
        synchronized (LOCK) {
            System.out.println("the music is skipping");
        }
    }

    public void previous() {
        synchronized (LOCK) {
            System.out.println("turn on previous music");
        }
    }
}

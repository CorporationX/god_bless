package faang.school.godbless.BJS2_5831;

public class Player {
    private final Object lock = new Object();
    private boolean isPlaying;

    public void play() {
        synchronized(lock) {
            if(isPlaying)
                System.out.println("Track is already playing.");
            else {
                System.out.println("Start playing Track.");
                isPlaying = true;
            }
        }
    }

    public void pause() {
        synchronized(lock) {
            if(isPlaying) {
                System.out.println("Track is paused.");
                isPlaying = false;
            }
            else
                System.out.println("Track is not playing.");
        }
    }

    public void skip() {
        synchronized(lock) {
            System.out.println("Track is skipped.");
        }
    }

    public void previous() {
        synchronized(lock) {
            System.out.println("Track is changed to previous.");
        }
    }
}
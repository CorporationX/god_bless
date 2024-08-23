package faang.school.godbless.BJS2_24515;

public class Player {
    private final Object lock = new Object();
    private boolean isPlaying = false;

    public void play() {
        synchronized (lock) {
            isPlaying = true;
            System.out.println("The music is playing " + isPlaying);
        }
    }

    public void pause() {
        synchronized (lock) {
            isPlaying = false;
            System.out.println("The music is paused " + isPlaying);
        }
    }

    public void skip() {
        synchronized (lock) {
            isPlaying = true;
            System.out.println("Song was skipped " + isPlaying);
        }
    }

    public void previous() {
        synchronized (lock) {
            isPlaying = true;
            System.out.println("The previous song is playing " + isPlaying);
        }
    }
}

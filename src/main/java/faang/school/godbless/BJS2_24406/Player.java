package faang.school.godbless.BJS2_24406;


public class Player {
    private final Object lock = new Object();
    private boolean isPlaying;

    public void play() {
        synchronized (lock) {
            isPlaying = true;
            System.out.println("Play! -> isPlaying: " + isPlaying);
        }
    }

    public void pause() {
        synchronized (lock) {
            isPlaying = false;
            System.out.println("Pause -> isPlaying: " + isPlaying);
        }
    }

    public void skip() {
        synchronized (lock) {
            isPlaying = true;
            System.out.println("Skip -> isPlaying: " + isPlaying);
        }
    }

    public void previous() {
        synchronized (lock) {
            isPlaying = true;
            System.out.println("Previous -> isPlaying: " + isPlaying);
        }
    }

}

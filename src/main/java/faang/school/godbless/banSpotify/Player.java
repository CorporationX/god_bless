package faang.school.godbless.banSpotify;

public class Player {
    private Object lock = new Object();
    private boolean isPlaying;
    public void play() {
        synchronized (lock) {
            isPlaying = true;
        }
        System.out.println("Music is playing!");
    }
    public void pause() {
        synchronized (lock) {
            isPlaying = false;
        }
        System.out.println("Music stopped!");
    }

    public void skip() {
        synchronized (lock) {
            isPlaying = true;
        }
        System.out.println("Music skipped!");
    }

    public void previous() {
        synchronized (lock) {
            isPlaying = false;
        }
        System.out.println("Previous!");
    }
}

package faang.school.godbless.BlockSpotify;

public class Player {
    private String song;
    private boolean isPlaying;
    private final Object lock = new Object();

    public Player(String song) {
        this.song = song;
        this.isPlaying = false;
    }

    public void play() {
        synchronized (lock) {
            if (!isPlaying) {
                isPlaying = true;
                System.out.println("Playing music: " + song);
            }
        }
    }

    public void pause() {
        synchronized (lock) {
            if (isPlaying) {
                isPlaying = false;
                System.out.println("Pausing music: " + song);
            }
        }
    }

    public void skip() {
        synchronized (lock) {
            System.out.println("Skipping music: " + song);
            isPlaying = true;
        }
    }

    public void previous() {
        synchronized (lock) {
            System.out.println("Playing previous music: " + song);
            isPlaying = true;
        }
    }

    public boolean isPlaying() {
        synchronized (lock) {
            return isPlaying;
        }
    }
}
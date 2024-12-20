package school.faang.spotify_lock;

public class Player {
    private final Object lock = new Object();
    private boolean isPlaying = false;
    private int nowPlayingId = 1;

    public void play() {
        synchronized (lock) {
            isPlaying = true;
            System.out.println("isPlaying = " + isPlaying());
        }
    }

    public void pause() {
        synchronized (lock) {
            isPlaying = false;
            System.out.println("isPlaying = " + isPlaying());
        }
    }

    public void skip() {
        synchronized (lock) {
            nowPlayingId++;
            System.out.println("nowPlayingId == " + getNowPlayingId());
        }
    }

    public void previous() {
        synchronized (lock) {
            if (--nowPlayingId == 0) {
                nowPlayingId = 1;
            }
            System.out.println("nowPlayingId == " + getNowPlayingId());
        }
    }

    public boolean isPlaying() {
        return isPlaying;
    }

    public int getNowPlayingId() {
        return nowPlayingId;
    }
}

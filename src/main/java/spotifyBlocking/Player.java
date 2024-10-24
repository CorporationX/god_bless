package spotifyBlocking;

public class Player {
    private boolean isPlaying = false;

    public synchronized void play() {
        isPlaying = true;
    }

    public synchronized void pause() {
        isPlaying = false;
    }

    public synchronized void skip() {

    }

    public synchronized void previous() {

    }

}

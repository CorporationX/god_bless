package faang.school.godbless.SpotifyBlocking;

public class Player {
    private Object lock = new Object();
    private boolean isPlaying;

    public void play() {
        synchronized(lock) {
            this.isPlaying = true;
            System.out.println("Play");
        }
    }
    public void pause() {
        synchronized(lock) {
            this.isPlaying = false;
            System.out.println("Pause");
        }
    }
    public void skip() {
        synchronized(lock) {
            this.isPlaying = false;
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            this.isPlaying = true;
            System.out.println("Skip");
        }
    }
    public void previous() {
        synchronized(lock) {
            this.isPlaying = false;
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            this.isPlaying = true;
            System.out.println("Previous");
        }
    }
}
package faang.school.godbless.sychronithation.spotify;

public class Player {
    private final Object lock = new Object();
    private boolean isPlaying;

    public void play() {
        synchronized (this.lock) {
            if (!isPlaying) {
                this.isPlaying = true;
                System.out.println("Song playing...");
            } else {
                System.out.println("The song is already playing");
            }
        }
    }

    public void pause() {
        synchronized (this.lock) {
            if (isPlaying) {
                this.isPlaying = false;
                System.out.println("Current song on pause...");
            } else {
                System.out.println("The song is already on pause");
            }
        }
    }

    public void skip() {
        synchronized (this.lock) {
            System.out.println(String.format("Skipped current song is playing:%s.", this.isPlaying));
        }
    }

    public void previous() {
        synchronized (this.lock) {
            System.out.println(String.format("Switch previous song is playing:%s.", this.isPlaying));
        }
    }
}

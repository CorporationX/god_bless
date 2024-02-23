package faang.school.godbless.spotifyblock2970;

public class Player {
    private final Object LOCK = new Object();
    private boolean isPlaying;

    public Player() {
        this.isPlaying = false;
    }

    public void play() {
        synchronized (this.LOCK) {
            if (this.isPlaying) {
                System.out.println("Playback is already on");
                return;
            }
            this.isPlaying = true;
            System.out.println("Playback is on. Enjoy your music :)");
        }
    }

    public void pause() {
        synchronized (this.LOCK) {
            if (!this.isPlaying) {
                System.out.println("Playback is already paused");
                return;
            }
            this.isPlaying = false;
            System.out.println("Playback is paused");
        }
    }

    public void skip() {
        synchronized (this.LOCK) {
            this.isPlaying = false;
            System.out.println("Playing next song");
            this.isPlaying = true;
        }
    }

    public void previous() {
        synchronized (this.LOCK) {
            this.isPlaying = false;
            System.out.println("Playing previous song");
            this.isPlaying = true;
        }
    }
}

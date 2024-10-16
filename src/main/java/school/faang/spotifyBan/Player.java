package school.faang.spotifyBan;

public class Player {
    private final Object lock = new Object();
    private boolean isPlaying;

    public void play() {
        synchronized (lock) {
            if (isPlaying) {
                System.out.println("The music is already playing");
            } else {
                isPlaying = true;
                System.out.println("The music started playing.");
            }
        }
    }

    public void pause() {
        synchronized (lock) {
            if (isPlaying) {
                isPlaying = false;
                System.out.println("The music is stopped.");
            } else {
                System.out.println("No music is playing at the moment.");
            }
        }
    }

    public void skip() {
        synchronized (lock) {
            System.out.println("The track is skipped");
        }
    }

    public void previous() {
        synchronized (lock) {
            System.out.println("Playing previous track.");
        }
    }
}

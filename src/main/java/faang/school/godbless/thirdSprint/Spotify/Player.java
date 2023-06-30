package faang.school.godbless.thirdSprint.Spotify;

public class Player {
    private final Object lock = new Object();
    private boolean isPlaying;

    public void play() {
        synchronized (lock) {
            System.out.println("Playlist launched");
            isPlaying = true;
            System.out.println("Is the music playing? " + isPlaying + "!");
        }
    }

    public void pause() {
        synchronized (lock) {
            System.out.println("Playlist stopped");
            isPlaying = false;
            System.out.println("Is the music playing? " + isPlaying + "!");
        }
    }

    public void skip() {
        synchronized (lock) {
            System.out.println("The current track has been skipped");
            isPlaying = true;
            System.out.println("Is the music playing? " + isPlaying + "!");
        }
    }

    public void previous() {
        synchronized (lock) {
            System.out.println("The previous track was started instead of the current track");
            isPlaying = true;
            System.out.println("Is the music playing? " + isPlaying + "!");
        }
    }
}

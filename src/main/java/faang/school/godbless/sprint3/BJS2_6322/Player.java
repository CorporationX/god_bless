package faang.school.godbless.sprint3.BJS2_6322;

public class Player {
    private static final int MAX_SONGS = 10;
    private final Object lock = new Object();
    private boolean isPlaying = false;
    private int songPosition = 0;

    public void play() {
        synchronized (lock) {
            isPlaying = true;
            System.out.println("Playing song at position: " + songPosition);
        }
    }

    public void pause() {
        synchronized (lock) {
            isPlaying = false;
            System.out.println("Paused song at position: " + songPosition);
        }
    }

    public void skip() {
        synchronized (lock) {
            pause();
            songPosition = songPosition == MAX_SONGS ? 0 : songPosition + 1;
            System.out.println("Skipped to next song: " + songPosition);
            play();
        }
    }

    public void previous() {
        synchronized (lock) {
            pause();
            songPosition = songPosition == 0 ? MAX_SONGS : songPosition - 1;
            System.out.println("Went back to previous song: " + songPosition);
            play();
        }
    }
}

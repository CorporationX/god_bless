package faang.school.godbless.spotify;

public class Player {
    private String lock = new String();
    private boolean isPlaying = false;
    private int songIndex = 0;
    private int SONGS_COUNTER = 100;

    private void printStatus() {
        System.out.printf("song %s is %s\n", songIndex, isPlaying ? "playing" : "paused");
    }

    public void play() {
        synchronized (lock) {
            System.out.println("play pressed");
            isPlaying = true;
            printStatus();
        }
    }

    public void pause() {
        synchronized (lock) {
            System.out.println("pause pressed");
            isPlaying = false;
            printStatus();
        }
    }

    public void skip() {
        synchronized (lock) {
            System.out.println("skip pressed");
            songIndex = (++songIndex) % SONGS_COUNTER;
            printStatus();
        }
    }

    public void previous() {
        synchronized (lock) {
            System.out.println("previous pressed");
            songIndex = (--songIndex) % SONGS_COUNTER;
            printStatus();
        }
    }
}

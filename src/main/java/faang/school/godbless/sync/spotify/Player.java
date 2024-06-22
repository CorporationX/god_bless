package faang.school.godbless.sync.spotify;

public class Player {

    private final Object lock = new Object();
    private boolean isPlaying;

    public void play() {
        synchronized (lock) {
            System.out.println("Playing the song");
            isPlaying = true;
            System.out.println("isPlaying now " + isPlaying);
        }
    }

    public void pause() {
        synchronized (lock) {
            System.out.println("Pausing the song");
            isPlaying = false;
            System.out.println("isPlaying now " + isPlaying);
        }
    }

    public void skip() {
        synchronized (lock) {
            System.out.println("Playing next");
            isPlaying = true;
            System.out.println("isPlaying now " + isPlaying);
        }
    }

    public void previous() {
        synchronized (lock) {
            System.out.println("Playing previous");
            isPlaying = true;
            System.out.println("isPlaying now " + isPlaying);
        }
    }
}

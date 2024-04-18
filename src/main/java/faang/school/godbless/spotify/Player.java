package faang.school.godbless.spotify;

public class Player {
    private String isPlaying;
    private final Object lock = new Object();

    public void play() {
        synchronized (lock) {
            isPlaying = "Playing";
            System.out.println("Music is playing");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public void pause() {
        synchronized (lock) {
            isPlaying = "Pausing";
            System.out.println("Music is paused");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

        }
    }

    public void skip() {
        synchronized (lock) {
            isPlaying = "Skip";
            System.out.println("Music skip");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public void previous() {
        synchronized (lock) {
            isPlaying = "Previous";
            System.out.println("Previous music");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}

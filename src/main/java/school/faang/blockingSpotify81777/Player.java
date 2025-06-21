package school.faang.blockingSpotify81777;

public class Player {

    static final Object lock = new Object();

    static boolean isPlaying = false;

    public void play() {
        for (int i = 0; i < 3; i++) {
            synchronized (lock) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                isPlaying = true;
                System.out.println("music is playing ");
            }
        }
    }

    public void pause() {
        for (int i = 0; i < 3; i++) {
            synchronized (lock) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                isPlaying = false;
                System.out.println("music is stop");
            }
        }
    }

    public void skip() {
        synchronized (lock) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            isPlaying = true;
            System.out.println("next track");
        }
    }

    public void previous() {
        synchronized (lock) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            isPlaying = true;
            System.out.println("previous track");
        }
    }
}

package school.faang.blockingspotify81777;

public class Player {

    private static final Object lock = new Object();

    private static boolean isPlaying = false;

    public void play() {

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

    public void pause() {

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

package faang.school.godbless.bjs2_5595;

public class Player {

    private final Object lock = new Object();
    private boolean isPlaying;

    public void play() {
        synchronized (lock) {
            isPlaying = true;
            System.out.println("Playing music...");
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public void pause() {
        synchronized (lock) {
            isPlaying = false;
            System.out.println("Music on pause...");
        }
    }

    public void skip() {
        synchronized (lock) {
            isPlaying = false;
            System.out.println("Music skip");
        }
    }

    public void previous() {
        synchronized (lock) {
            isPlaying = false;
            System.out.println("Previous...");
        }
    }
}

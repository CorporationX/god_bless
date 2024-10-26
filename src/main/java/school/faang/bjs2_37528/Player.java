package school.faang.bjs2_37528;


public class Player {
    private final Object lock = new Object();

    private boolean isPlaying;

    public void play() {
        synchronized (lock) {
            isPlaying = true;
            System.out.println("play track");
        }
    }

    public void pause() {
        synchronized (lock) {
            isPlaying = false;
            System.out.println("pause track");
        }
    }

    public void skip() {
        synchronized (lock){
            System.out.println("skip track");
        }
    }

    public void previous() {
        synchronized (lock){
            System.out.println("previous track");
        }
    }
}

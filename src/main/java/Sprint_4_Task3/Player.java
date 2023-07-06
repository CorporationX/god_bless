package Sprint_4_Task3;

public class Player {
    private final Object lock = new Object();
    private boolean isPlaying;
    public void play() {
        synchronized (lock){
            isPlaying = true;
            System.out.println(Thread.currentThread().getName() + " Playing " + isPlaying);
        }
    }
    public void pause() {
        synchronized (lock){
            isPlaying = true;
            System.out.println(Thread.currentThread().getName() + " Paused " + isPlaying);
        }
    }
    public void skip() {
        synchronized (lock){
            isPlaying = true;
            System.out.println(Thread.currentThread().getName() + " Skipped " + isPlaying);
        }
    }
    public void previous() {
        synchronized (lock){
            isPlaying = true;
            System.out.println(Thread.currentThread().getName() + " Previous " + isPlaying);
        }
    }
}

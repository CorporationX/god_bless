package Sprint_4_Task3;

public class Player {
    private final Object lock = new Object();
    private boolean isPlaying;
    public void play() {
        synchronized (lock){
            isPlaying = true;
            System.out.println(Thread.currentThread().getName() + " Playing " + isPlaying);
            lock.notifyAll();
        }
    }
    public void pause() {
        synchronized (lock){
            isPlaying = true;
            System.out.println(Thread.currentThread().getName() + " Paused " + isPlaying);
            lock.notifyAll();
        }
    }
    public void skip() {
        synchronized (lock){
            isPlaying = true;
            System.out.println(Thread.currentThread().getName() + " Skipped " + isPlaying);
            lock.notifyAll();
        }
    }
    public void previous() {
        synchronized (lock){
            isPlaying = true;
            System.out.println(Thread.currentThread().getName() + " Previous " + isPlaying);
            lock.notifyAll();
        }
    }
}

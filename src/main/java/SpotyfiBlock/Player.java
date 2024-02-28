package SpotyfiBlock;

import lombok.SneakyThrows;

public class Player {
    private boolean isPlaying = false;
    private final Object lock = new Object();
    public void play(){
        synchronized (lock) {
            isPlaying = true;
            System.out.println("Music played");
        }
    }
    public synchronized void pause(){
        synchronized (lock) {
            isPlaying = false;
            System.out.println("Music paused");
        }
    }
    public synchronized void skip() {
        synchronized (lock) {
            System.out.println("Music skip");
        }
    }

    public synchronized void previous(){
        synchronized (lock) {
            System.out.println("Music previous");
        }
    }

    @SneakyThrows
    public static void main(String[] args) {
        Player player = new Player();
        Thread playThread = new Thread(player::play);
        Thread pauseThread = new Thread(player::pause);
        Thread skipThread = new Thread(player::skip);
        Thread previousThread = new Thread(player::previous);
        playThread.start();
        pauseThread.start();
        skipThread.start();
        previousThread.start();
    }
}

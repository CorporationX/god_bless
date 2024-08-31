package faang.school.godbless.dolbahlop.multithreading.synchronization;

public class Music {
    public static void main(String[] args) {
        Player player = new Player();
        Thread playingThread = new Thread(() -> player.play());
        Thread pauseThread = new Thread(() -> player.pause());
        Thread skipThread = new Thread(() -> player.skip());
        Thread previousThread = new Thread(() -> player.previous());
        playingThread.start();
        pauseThread.start();
        skipThread.start();
        previousThread.start();
    }
}

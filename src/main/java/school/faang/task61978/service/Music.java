package school.faang.task61978.service;

public class Music {
    Player player = new Player();

    public void simulatePlayer() {
        Thread playThread = new Thread(() -> player.play());
        playThread.start();

        Thread pauseThread = new Thread(() -> player.pause());
        pauseThread.start();

        Thread skipThread = new Thread(() -> player.skip());
        skipThread.start();

        Thread prevThread = new Thread(() -> player.previous());
        prevThread.start();
    }
}

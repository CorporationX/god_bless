package school.faang.blocking_spotify.BJS2_61770;

public class Music {
    public void multiUserSimulation() {
        Player player = new Player();

        Thread playThread = new Thread(() -> player.play());
        Thread pauseThread = new Thread(() -> player.pause());
        Thread skipThread = new Thread(() -> player.skip());
        Thread previousThread = new Thread(() -> player.previous());

        playThread.start();
        pauseThread.start();
        skipThread.start();
        previousThread.start();
    }
}

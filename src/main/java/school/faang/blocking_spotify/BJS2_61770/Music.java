package school.faang.blocking_spotify.BJS2_61770;

public class Music {
    private Thread playThread;
    private Thread pauseThread;
    private Thread skipThread;
    private Thread previousThread;

    public void multiUserSimulation() {
        Player player = new Player();

        playThread = new Thread(() -> player.play());
        pauseThread = new Thread(() -> player.pause());
        skipThread = new Thread(() -> player.skip());
        previousThread = new Thread(() -> player.previous());

        playThread.start();
        pauseThread.start();
        skipThread.start();
        previousThread.start();
    }
}

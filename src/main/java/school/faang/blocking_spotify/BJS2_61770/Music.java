package school.faang.blocking_spotify.BJS2_61770;

public class Music {
    private final Player player = new Player();
    private final Thread playThread = new Thread(() -> player.play());
    private final Thread pauseThread  = new Thread(() -> player.pause());
    private final Thread skipThread  = new Thread(() -> player.play());
    private final Thread previousThread  = new Thread(() -> player.previous());

    public void multiUserSimulation() {
        playThread.start();
        pauseThread.start();
        skipThread.start();
        previousThread.start();
    }
}

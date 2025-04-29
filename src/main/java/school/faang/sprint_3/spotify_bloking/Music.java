package school.faang.sprint_3.spotify_bloking;

public class Music {
    Player player;

    public Music() {
        this.player = new Player();
        startThreads();
    }

    private void startThreads() {
        Thread playThread = new Thread(player::play);
        playThread.start();

        Thread pauseThread = new Thread(player::pause);
        pauseThread.start();

        Thread skipThread = new Thread(player::skip);
        skipThread.start();

        Thread previousThread = new Thread(player::previous);
        previousThread.start();
    }
}

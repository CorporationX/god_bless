package BJS2_24315_BlockingSpotify;

public class Music {
    private static final Player player = new Player();

    public static void main(String[] args) {
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

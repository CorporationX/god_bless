package spotify_blocking;

public class Music {
    public static void main(String[] args) {
        Player player = new Player();

        Thread playThread = new Thread(player::play);
        Thread pauseThread = new Thread(player::pause);
        Thread previousThread = new Thread(player::previous);
        Thread skipThread = new Thread(player::skip);

        playThread.start();
        pauseThread.start();
        previousThread.start();
        skipThread.start();
    }
}

package stream.spotify;

public class Music {
    public static void main(String[] args) {
        Player player = new Player();
        Thread pauseThread = new Thread(player::previous);
        Thread skipThread = new Thread(player::skip);
        Thread playThread = new Thread(player::play);
        Thread previousThread = new Thread(player::pause);

        playThread.start();
        pauseThread.start();
        skipThread.start();
        previousThread.start();

    }
}

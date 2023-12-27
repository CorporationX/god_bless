package Spotify;

public class Music {
    public static void main(String[] args) throws InterruptedException {
        Player player = new Player();

        Thread playThread = new Thread(player::play);
        Thread pauseThread = new Thread(player::pause);
        Thread skipThread = new Thread(player::skip);
        Thread preaviousThread = new Thread(player::previous);

        playThread.start();
        pauseThread.start();
        skipThread.start();
        preaviousThread.start();

        Thread.sleep(1000);

    }
}

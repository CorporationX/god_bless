package Spotify;


public class Music {
    public static void main(String[] args) throws InterruptedException {
        Thread playThread = new Thread(Player::play);
        Thread pauseThread = new Thread(Player::pause);
        Thread skipThread = new Thread(Player::skip);
        Thread previousThread = new Thread(Player::previous);

        playThread.start();
        skipThread.start();
        pauseThread.start();
        previousThread.start();
    }
}

package faang.school.godbless.spotify_blocking;

public class Music {
    public static void main(String[] args) {
        Player player1 = new Player();
        Thread playThread = new Thread(player1::play);
        Thread pauseThread = new Thread(player1::pause);
        Thread skipThread = new Thread(player1::skip);
        Thread previousThread = new Thread(player1::previous);

        playThread.start();
        pauseThread.start();
        skipThread.start();
        previousThread.start();
    }
}

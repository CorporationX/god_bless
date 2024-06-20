package faang.school.godbless.spotify;

public class Music {
    public static void main(String[] args) {
        Player player = new Player();

        Thread playThread = new Thread(player::play);
        Thread previousThread = new Thread(player::previous);
        Thread skipThread = new Thread(player::skip);
        Thread pauseThread = new Thread(player::pause);

        pauseThread.start();
        playThread.start();
        skipThread.start();
        previousThread.start();
    }
}

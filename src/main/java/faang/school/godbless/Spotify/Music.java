package faang.school.godbless.Spotify;

public class Music {
    public static void main(String[] args) {
        Player player = new Player("Track");
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

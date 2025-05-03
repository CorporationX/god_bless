package school.faang.spotify.spotify;

public class Music {
    public static void main(String[] args) {
        Player player = new Player();

        Thread playThread = new Thread(player::play);
        playThread.start();
        Thread pauseThread = new Thread(player::pause);
        pauseThread.start();
        Thread skipThread = new Thread(player::skip);
        skipThread.start();
        Thread previousThread = new Thread(player::previous);
        previousThread.start();

        try {
            playThread.join();
            pauseThread.join();
            skipThread.join();
            previousThread.join();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
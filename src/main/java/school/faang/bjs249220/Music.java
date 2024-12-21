package school.faang.bjs249220;

public class Music {
    public static void main(String[] args) {
        Player player = new Player(false);

        final Thread playbackThread = new Thread(player::play);
        final Thread pauseThread = new Thread(player::pause);
        final Thread skipThread = new Thread(player::skip);
        final Thread previousThread = new Thread(player::previous);

        playbackThread.start();
        pauseThread.start();
        skipThread.start();
        previousThread.start();
    }
}

package faang.school.godbless.spotifyblocking;

public class Music {
    public static void main(String[] args) {
        Player player = new Player();

        Thread playThread = new Thread(player::play);
        Thread pauseThread = new Thread(player::pause);
        Thread skipThread = new Thread(player::skip);
        Thread previousThread = new Thread(player::previous);

        playThread.start();
        pauseThread.start();
        skipThread.start();
        previousThread.start();
        try {
            playThread.join();
            pauseThread.join();
            skipThread.join();
            previousThread.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
package school.faang.spotify;

public class Main {

    public static void main(String[] args) {
        Player player = new Player();

        Thread playThread = new Thread(player::play);
        Thread stopThread = new Thread(player::stop);
        Thread skipThread = new Thread(player::skip);
        Thread previousThread = new Thread(player::previous);

        playThread.start();
        stopThread.start();
        skipThread.start();
        previousThread.start();

        try {
            playThread.join();
            stopThread.join();
            skipThread.join();
            previousThread.join();
        } catch (InterruptedException e) {
            throw new IllegalStateException("Thread was interrupted", e);
        }
    }
}

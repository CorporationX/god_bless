package school.faang.blockSpotify;

public class Music {
    public static void main(String[] args) throws InterruptedException {
        Player player = new Player();

        Thread skipThread = new Thread(() -> player.skip(), "Skip");
        skipThread.start();
        Thread previousThread = new Thread(() -> player.previous(), "Previous");
        previousThread.start();
        Thread playThread = new Thread(() -> player.play(), "Play");
        playThread.start();
        Thread pauseThread = new Thread(() -> player.pause(), "Pause");
        pauseThread.start();

        skipThread.join();
        previousThread.join();
        playThread.join();
        pauseThread.join();
    }
}
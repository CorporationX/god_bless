package school.faang.BJS2_61698;

public class Music {
    public static void main(String[] args) throws InterruptedException {
        Player player = new Player();

        final Thread playThread = new Thread(player::play);
        final Thread pauseThread = new Thread(player::pause);
        final Thread skipThread = new Thread(player::skip);
        final Thread previousThread = new Thread(player::previous);

        playThread.start();
        Thread.sleep(1000);
        pauseThread.start();
        Thread.sleep(1000);
        skipThread.start();
        Thread.sleep(1000);
        previousThread.start();
    }
}
package spotify;

public class MusicGroupSession {

    public static void main(String[] args) throws InterruptedException {
        Player player = new Player();

        Thread playThread = new Thread(player::play);
        playThread.start();

        Thread pauseThread = new Thread(player::pause);
        pauseThread.start();

        Thread skipThread = new Thread(player::skip);
        skipThread.start();

        Thread previousThread = new Thread(player::previous);
        previousThread.start();

        playThread.join();
        pauseThread.join();
        skipThread.join();
        previousThread.join();

        System.out.println("Done");
    }
}

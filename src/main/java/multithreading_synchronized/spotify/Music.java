package multithreading_synchronized.spotify;

public class Music {
    public static void main(String[] args) {
        Player player = new Player();

        Thread threadPlay = new Thread(() -> player.play());
        Thread threadPause = new Thread(() -> player.pause());
        Thread threadSkip = new Thread(() -> player.skip());
        Thread threadPrevious = new Thread(() -> player.previous());

        threadPlay.start();
        threadPause.start();
        threadSkip.start();
        threadPrevious.start();

    }
}

package faang.school.godbless.sync.spotify;

public class Music {

    public static void main(String[] args) throws InterruptedException {
        var player = new Player();
        var playThread = new Thread(player::play);
        var pauseThread = new Thread(player::pause);
        var skipThread = new Thread(player::skip);
        var previousThread = new Thread(player::previous);
        playThread.start();
        previousThread.start();
        pauseThread.start();
        skipThread.start();
        Thread.sleep(5000);
    }
}

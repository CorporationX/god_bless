package school.faang.synchronization.spotify;

public class Music {

    public static void main(String[] args) {
        Object lock = new Object();
        Player player = new Player(lock);
        Thread threadPlay = new Thread(player::play);
        Thread threadPause = new Thread(player::pause);
        Thread threadSkip = new Thread(player::pause);
        Thread threadPrevious = new Thread(player::previous);
            threadPlay.start();
            threadPause.start();
            threadSkip.start();
            threadPrevious.start();
    }

}

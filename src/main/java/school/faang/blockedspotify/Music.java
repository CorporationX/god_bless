package school.faang.blockedspotify;

public class Music {

    public static void main(String[] args) {
        Player player = new Player(new Locker());
        Thread threadPlay = new Thread(player::play);
        Thread threadPause = new Thread(player::pause);
        Thread threadSkip = new Thread(player::skip);
        Thread threadPrevious = new Thread(player::previous);

        threadPlay.start();
        threadPause.start();
        threadSkip.start();
        threadPrevious.start();
    }

}

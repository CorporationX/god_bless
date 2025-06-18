package school.faang.bjs2_81736;

public class Music {

    public static void main(String[] args) {
        Player player = new Player();

        Thread threadPause = new Thread(player::pause);
        threadPause.start();

        Thread threadPlay = new Thread(player::play);
        threadPlay.start();

        Thread threadSkip = new Thread(player::skip);
        threadSkip.start();

        Thread threadPrevious = new Thread(player::previous);
        threadPrevious.start();
    }
}

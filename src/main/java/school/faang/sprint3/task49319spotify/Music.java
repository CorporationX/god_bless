package school.faang.sprint3.task49319spotify;

public class Music {
    public static void main(String[] args) {
        Thread threadPlay = new Thread(
                Player::play
        );

        Thread threadPause = new Thread(
                Player::pause
        );
        Thread threadSkip = new Thread(
                Player::skip
        );

        Thread threadPrevious = new Thread(
                Player::previous
        );
        threadPlay.start();
        threadPause.start();
        threadSkip.start();
        threadPrevious.start();
    }
}

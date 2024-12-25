package school.faang.sprint3.task49319spotify;

public class Music {
    public static void main(String[] args) {
        final Thread threadPlay = new Thread(
                Player::play
        );

        final Thread threadPause = new Thread(
                Player::pause
        );
        final Thread threadSkip = new Thread(
                Player::skip
        );

        final Thread threadPrevious = new Thread(
                Player::previous
        );

        threadPlay.start();
        threadPrevious.start();
        threadPause.start();
        threadSkip.start();
    }
}

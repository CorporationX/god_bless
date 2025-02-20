package school.faang.sprint3.bjs2_61779;

public class Music {
    public static void main(String[] args) {
        Player player = new Player();

        final Thread playThread1 = new Thread(player::play);
        final Thread playThread = new Thread(player::play);
        final Thread pauseThread1 = new Thread(player::pause);
        final Thread pauseThread = new Thread(player::pause);
        final Thread skipThread = new Thread(player::skip);
        final Thread previousThread = new Thread(player::previous);

        playThread.start();
        playThread1.start();
        pauseThread.start();
        pauseThread1.start();
        skipThread.start();
        previousThread.start();
    }
}

package school.faang.sprint3.bjs2_61779;

public class Music {
    public static void main(String[] args) {
        Player player = new Player();

        Thread playThread1 = new Thread(player::play);
        Thread playThread = new Thread(player::play);
        Thread pauseThread1 = new Thread(player::pause);
        Thread pauseThread = new Thread(player::pause);
        Thread skipThread = new Thread(player::skip);
        Thread previousThread = new Thread(player::previous);

        playThread.start();
        playThread1.start();
        pauseThread.start();
        pauseThread1.start();
        skipThread.start();
        previousThread.start();
    }
}

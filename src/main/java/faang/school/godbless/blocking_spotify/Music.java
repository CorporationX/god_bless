package faang.school.godbless.blocking_spotify;

public class Music {
    public static void main(String[] args) {
        Player player = new Player();

        Thread playThread = new Thread(player::play);
        Thread pauseThread = new Thread(player::pause);
        Thread skipThread = new Thread(player::skip);
        Thread previousThread = new Thread(player::previous);

        Thread playThread2 = new Thread(player::play);
        Thread pauseThread2 = new Thread(player::pause);
        Thread skipThread2 = new Thread(player::skip);
        Thread previousThread2 = new Thread(player::previous);

        playThread.start();
        playThread2.start();

        pauseThread.start();
        pauseThread2.start();

        skipThread.start();
        skipThread2.start();

        previousThread.start();
        previousThread2.start();
    }
}
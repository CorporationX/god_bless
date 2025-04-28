package school.faang.bjs273231;

public class Music {
    public static void main(String[] args) {
        Player player = new Player();

        Thread playThread = new Thread(player::play);
        Thread pauseThread2 = new Thread(player::pause);
        Thread skipThread3 = new Thread(player::skip);
        playThread.start();
        pauseThread2.start();
        skipThread3.start();
    }
}

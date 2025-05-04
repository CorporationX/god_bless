package school.faang.BJS2_73273;

public class Music {
    public static void main(String[] args) {
        Player player = new Player();
        Thread playerThread = new Thread(player::play);
        playerThread.start();
        Thread pauseThread = new Thread(player::pause);
        pauseThread.start();
        Thread skipThread = new Thread(player::skip);
        skipThread.start();
        Thread previousThread = new Thread(player::previous);
        previousThread.start();
    }
}

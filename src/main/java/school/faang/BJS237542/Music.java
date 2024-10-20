package school.faang.BJS237542;

public class Music {
    public static void main(String[] args) {
        Player player = new Player();
        Thread playThread = new Thread(player::play);
        Thread pauseThread = new Thread(player::pause);
        Thread skipThread = new Thread(player::previous);
        Thread previousThread = new Thread(player::skip);

        playThread.start();
        pauseThread.start();
        skipThread.start();
        previousThread.start();
    }
}

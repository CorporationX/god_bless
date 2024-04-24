package BJS2_5947;

public class Music {
    public static void main(String[] args) {
        Player player = new Player();

        Thread playTread = new Thread(player::play);
        Thread pauseThread = new Thread(player::pause);
        Thread skipThread = new Thread(player::skip);
        Thread previousThread = new Thread(player::previous);

        playTread.start();
        pauseThread.start();
        skipThread.start();
        previousThread.start();
    }
}

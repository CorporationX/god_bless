package school.faang;

public class Music {

    public static void main(String[] args) {
        Player player = new Player();
        Thread playThread = new Thread(() -> player.play());
        playThread.start();

        Thread pauseThread = new Thread(() -> player.pause());
        pauseThread.start();

        Thread skipThread = new Thread(() -> player.skip());
        skipThread.start();

        Thread previousThread = new Thread(() -> player.previous());
        previousThread.start();
    }
}

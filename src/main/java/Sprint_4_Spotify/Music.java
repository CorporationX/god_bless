package Sprint_4_Spotify;

public class Music {
    public static void main(String[] args) {

        System.out.println("Музыка включена");

        Player player = new Player(true);

        Thread playThread = new Thread(() -> player.play());
        Thread pauseThread = new Thread(() -> player.pause());
        Thread skipThread = new Thread(() -> player.skip());
        Thread previousThread = new Thread(() -> player.previous());

        playThread.start();
        pauseThread.start();
        skipThread.start();
        previousThread.start();

    }
}

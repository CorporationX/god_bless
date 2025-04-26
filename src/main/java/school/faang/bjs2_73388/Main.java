package school.faang.bjs2_73388;

public class Main {
    private static final Player PLAYER = new Player();
    private static final Thread PLAY = new Thread(() -> PLAYER.play(), "PLAY THREAD");
    private static final Thread PAUSE = new Thread(() -> PLAYER.pause(), "PAUSE THREAD");
    private static final Thread SKIP = new Thread(() -> PLAYER.skip(), "SKIP THREAD");
    private static final Thread PREVIOUS = new Thread(() -> PLAYER.prevoius(), "PREVIOUS THREAD");

    public static void main(String[] args) {
        PLAY.start();
        PAUSE.start();
        SKIP.start();
        PREVIOUS.start();
    }
}

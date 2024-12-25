package school.faang.sprint3.bjs249327;

public class Music {
    private final Player player = new Player();

    public void start() {
        try {
            Thread playThread = new Thread(player::play);
            Thread pauseThread = new Thread(player::pause);
            Thread skipThread = new Thread(player::skip);
            Thread previousThread = new Thread(player::previous);

            playThread.start();
            pauseThread.start();
            skipThread.start();
            previousThread.start();
        } catch (Exception e) {
            System.err.println("Непредвиденное исключение: " + e.getMessage());
        }
    }
}
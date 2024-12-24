package school.faang.bjs249511;

public class Music {

    public static Thread playThread;
    public static Thread playThreadAgain;
    public static Thread playThreadOnceMore;
    public static Thread pauseThread;
    public static Thread skipThread;
    public static Thread previousThread;

    public static void main(String[] args) {

        Player player = new Player();

        playThread = getPlayThread(player);
        playThreadAgain = getPlayThread(player);
        playThreadOnceMore = getPlayThread(player);

        pauseThread = new Thread(player::pause);
        skipThread = new Thread(player::skip);
        previousThread = new Thread(player::previous);

        playThread.start();
        playThreadAgain.start();
        playThreadOnceMore.start();

        pauseThread.start();
        skipThread.start();
        previousThread.start();
    }

    private static Thread getPlayThread(Player player) {
        return new Thread(player::play);
    }
}

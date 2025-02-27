package school.faang.spotify;

public class Music {
    public static void main(String[] args) {
        Player player = new Player();

        Thread playThread = createAndStartThread(player::play);
        Thread pauseThread = createAndStartThread(player::pause);
        Thread skipThread = createAndStartThread(player::skip);
        Thread previousThread = createAndStartThread(player::previous);
    }

    private static Thread createAndStartThread(Runnable task) {
        Thread thread = new Thread(task);
        thread.start();
        return thread;
    }
}

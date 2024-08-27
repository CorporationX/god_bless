package faang.school.godbless.BJS224342;

public class Music {
    public static void main(String[] args) {
        Player player = new Player();

        Thread playerThread = new Thread(player::play, "PlayThread");
        Thread pauseThread = new Thread(player::pause, "PauseThread");
        Thread skipThread = new Thread(player::skip, "SkipThread");
        Thread previousThread = new Thread(player::previous, "PreviousThread");

        playerThread.start();
        pauseThread.start();
        skipThread.start();
        previousThread.start();

        try {
            playerThread.join();
            pauseThread.join();
            skipThread.join();
            previousThread.join();
        } catch (InterruptedException e) {
            System.err.println("Thread interrupted: " + e.getMessage());
        }
    }
}

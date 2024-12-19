package school.faang.task_49177;

public class Music {
    public static void main(String[] args) {
        Player player = new Player();

        Thread playThread = new Thread(player::play, "PlayThread");
        playThread.start();

        Thread pauseThread = new Thread(player::pause, "PauseThread");
        pauseThread.start();

        Thread skipThread = new Thread(player::skip, "SkipThread");
        skipThread.start();

        Thread previousThread = new Thread(player::previous, "PreviousThread");
        previousThread.start();
    }
}
package school.faang.sprint3.task_bjs249278;

public class Music {
    public static void main(String[] args) {
        Player player = new Player();

        Thread playThread = new Thread(player::play);
        Thread playThreadAgain = new Thread(player::play);
        Thread pauseThread = new Thread(player::pause);
        Thread pauseThreadAgain = new Thread(player::pause);
        Thread skipThread = new Thread(player::skip);
        Thread previousThread = new Thread(player::previous);

        playThread.start();
        playThreadAgain.start();
        pauseThread.start();
        pauseThreadAgain.start();
        skipThread.start();
        previousThread.start();
    }
}

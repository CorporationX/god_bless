package faang.school.godbless.multithreading_synchronization.task_1;

public class Music {
    public static void main(String[] args) {
        final Player player = new Player();
        final Thread playThread = new Thread(player::play);
        final Thread pauseThread = new Thread(player::pause);
        final Thread skipThread = new Thread(player::skip);
        final Thread previousThread = new Thread(player::previous);

        playThread.start();
        pauseThread.start();
        skipThread.start();
        previousThread.start();
    }
}

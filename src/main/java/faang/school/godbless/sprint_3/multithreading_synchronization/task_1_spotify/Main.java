package faang.school.godbless.sprint_3.multithreading_synchronization.task_1_spotify;

public class Main {
    public static final String MSG_FINISH = "Работа программы завершена.";
    public static final String MSG_ERROR = "Работа программы прервана.";

    public static void main(String[] args) throws InterruptedException {
        Player player = new Player();

        startThreads(player);

        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            throw new RuntimeException(MSG_ERROR);
        }

        System.out.println(MSG_FINISH);

    }

    private static void startThreads(Player player) {
        Thread playThread = new Thread(player::play);
        Thread pauseThread = new Thread(player::pause);
        Thread skipThread = new Thread(player::skip);
        Thread previousThread = new Thread(player::previous);

        playThread.start();
        pauseThread.start();
        skipThread.start();
        previousThread.start();
    }
}

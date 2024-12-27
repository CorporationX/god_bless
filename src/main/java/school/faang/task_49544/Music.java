package school.faang.task_49544;

public class Music {
    public static void main(String[] args) {
        Player player = new Player();

        Thread playThread = new Thread(player::play, "Пользователь 1");
        Thread pauseThread = new Thread(player::pause, "Пользователь 2");
        Thread skipThread = new Thread(player::skip, "Пользователь 3");
        Thread previousThread = new Thread(player::previous, "Пользователь 4");

        playThread.start();
        pauseThread.start();
        skipThread.start();
        previousThread.start();
    }
}

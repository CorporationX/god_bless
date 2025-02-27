package school.faang.task_63598;

public class Music {
    public static void main(String[] args) {
        Player player = new Player();

        Thread playThread = new Thread(player::play, "Пользователь 1");
        playThread.start();

        Thread pauseThread = new Thread(player::pause, "Пользователь 2");
        pauseThread.start();

        Thread skipThread = new Thread(player::skip, "Пользователь 3");
        skipThread.start();

        Thread previousThread = new Thread(player::previous, "Пользователь 4");
        previousThread.start();
    }
}

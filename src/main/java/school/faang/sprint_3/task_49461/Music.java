package school.faang.sprint_3.task_49461;

public class Music {
    public static void main(String[] args) {
        Player player = new Player();

        Runnable[] tasks = {
                player::play,
                player::pause,
                player::skip,
                player::previous
        };

        for (Runnable task : tasks) {
            new Thread(task).start();
        }

    }
}

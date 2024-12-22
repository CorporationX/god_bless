package school.faang.sprint3.task_49307;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    private static final int THREAD_POOL_SIZE = 5;

    public static void main(String[] args) {
        Player player = new Player();

        ExecutorService executorService = Executors.newFixedThreadPool(THREAD_POOL_SIZE);

        Runnable[] tasks = {
                player::play,
                player::previous,
                player::pause,
                player::skip
        };

        for (int i = 0; i < 3; i++) {
            for (Runnable task : tasks) {
                executorService.submit(task);
            }
        }

        executorService.shutdown();
    }
}

package school.faang.sprint_3.task_43563;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Music {
    private static final int POOL_SIZE = 4;

    public static void main(String[] args) {
        Player player = new Player();
        ExecutorService executor = Executors.newFixedThreadPool(POOL_SIZE);

        for (int i = 0; i < 5; i++) {
            executor.execute(player::play);
            executor.execute(player::pause);
            executor.execute(player::skip);
            executor.execute(player::previous);
        }

        executor.shutdown();
    }
}
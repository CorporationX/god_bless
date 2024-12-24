package school.faang.sprint_3.task_49288;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Music {
    private static final int NUMBERS_OF_THREADS = 4;

    public static void main(String[] args) {
        Player player = new Player();

        ExecutorService executor = Executors.newFixedThreadPool(NUMBERS_OF_THREADS);
        for (int i = 0; i < NUMBERS_OF_THREADS; i++) {
            executor.submit(player::play);
            executor.submit(player::pause);
            executor.submit(player::skip);
            executor.submit(player::previous);
        }
        executor.shutdown();
    }
}

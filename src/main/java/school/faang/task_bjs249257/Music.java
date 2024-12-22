package school.faang.task_bjs249257;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Music {
    private static final int POOL_SIZE = 4;

    public static void main(String[] args) {
        Player player = new Player();
        ExecutorService executorService = Executors.newFixedThreadPool(POOL_SIZE);
        for (int i = 0; i < 8; i++) {
            executorService.submit(player::pause);
            executorService.submit(player::play);
            executorService.submit(player::skip);
            executorService.submit(player::previous);
        }
        executorService.shutdown();
    }
}

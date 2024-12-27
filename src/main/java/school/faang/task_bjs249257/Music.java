package school.faang.task_bjs249257;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Music {
    private static final int POOL_SIZE = 4;
    private static final int TEST_CYCLES_COUNT = 8;

    public static void main(String[] args) {
        Player player = new Player();
        ExecutorService executorService = Executors.newFixedThreadPool(POOL_SIZE);
        List<Runnable> actions = Arrays.asList(player::pause, player::play,
                player::skip, player::previous);

        for (int i = 0; i < TEST_CYCLES_COUNT; i++) {
            for (Runnable action : actions) {
                executorService.submit(action);
            }
        }
        executorService.shutdown();
    }
}

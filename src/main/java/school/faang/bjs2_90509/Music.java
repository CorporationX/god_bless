package school.faang.bjs2_90509;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Music {
    private static final int THREAD_COUNT = 5;
    private static final int TASK_COUNT = 100;
    private static final int SECOND_TASK = 2;
    private static final int THIRD_TASK = 3;
    private static final int FOURTH_TASK = 4;

    private final ExecutorService executorService = Executors.newFixedThreadPool(THREAD_COUNT);
    private final Player player = new Player();

    public void startThreads() {
        for (int i = 0; i < TASK_COUNT; i++) {
            int threadNumber = i % THREAD_COUNT;
            switch (threadNumber) {
                case SECOND_TASK:
                    executorService.execute(player::pause);
                    break;
                case THIRD_TASK:
                    executorService.execute(player::skip);
                    break;
                case FOURTH_TASK:
                    executorService.execute(player::previous);
                    break;
                default:
                    executorService.execute(player::play);
            }
        }
        executorService.shutdown();
    }
}

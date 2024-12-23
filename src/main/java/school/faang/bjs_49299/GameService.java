package school.faang.bjs_49299;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class GameService {
    private static final int START_SCORE = 0;
    private static final int START_LIVES = 5;
    private static final int THREAD_POOL_SIZE = 10;

    public void gameStart() {
        List<Runnable> addScoreRunnable = new ArrayList<>();
        Game game = new Game(START_SCORE, START_LIVES);

        addScoreRunnable.add(() -> game.update(true, false));
        addScoreRunnable.add(() -> game.update(false, true));
        addScoreRunnable.add(() -> game.update(true, true));
        addScoreRunnable.add(() -> game.update(false, false));

        ExecutorService executorService = Executors.newFixedThreadPool(THREAD_POOL_SIZE);

        while (game.isRunning()) {
            addScoreRunnable.forEach(executorService::submit);
        }

        executorService.shutdown();
    }
}

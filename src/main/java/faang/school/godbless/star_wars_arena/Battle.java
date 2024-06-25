package faang.school.godbless.star_wars_arena;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Battle {
    ExecutorService executorService = Executors.newCachedThreadPool();

    public Future<Robot> fight(Robot robot1, Robot robot2) {
        return executorService.submit(() -> {
            int compare = robot1.compareTo(robot2);
            return compare > 0 ? robot1 : robot2;
        });
    }

    public void shutdownExecutorService() {
        executorService.shutdown();
    }
}

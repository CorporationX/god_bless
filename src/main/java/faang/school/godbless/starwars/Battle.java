package faang.school.godbless.starwars;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.function.BiConsumer;

public class Battle {

    private final ExecutorService EXECUTOR_SERVICE = Executors.newCachedThreadPool();

    public Future<Robot> fight(Robot robot1, Robot robot2, BiConsumer<Robot, Robot> battleLogic) {
        return EXECUTOR_SERVICE.submit(() -> {
            while (robot1.isAlive() && robot2.isAlive()) {
                battleLogic.accept(robot1, robot2);
            }
            return getWinner(robot1, robot2);
        });
    }

    public void shutdownAndAwaitExecution(Long minutes) {
        EXECUTOR_SERVICE.shutdown();
        awaitTermination(minutes);
    }

    private void awaitTermination(Long minutes) {
        try {
            EXECUTOR_SERVICE.awaitTermination(minutes, TimeUnit.MINUTES);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    private Robot getWinner(Robot robot1, Robot robot2) {
        if (robot1.isAlive()) {
            return robot1;
        } else {
            return robot2;
        }
    }
}

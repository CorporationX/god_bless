package school.faang.sprint_4.task_43576;

import lombok.SneakyThrows;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Battle {
    private static final int POOL_SIZE = 2;
    private static final int SLEEP_TIME = 5_000;

    private final ExecutorService executor = Executors.newFixedThreadPool(POOL_SIZE);

    @SneakyThrows(InterruptedException.class)
    public Future<Robot> fight(Robot robot1, Robot robot2) {
        System.out.println("Идет битва между " + robot1.name() + " и " + robot2.name());
        Thread.sleep(SLEEP_TIME);
        Future<Robot> future = executor.submit(() -> {
                    int robot1Power = robot1.attackPower() + robot1.defensePower();
                    int robot2Power = robot2.attackPower() + robot2.defensePower();
                    return robot1Power > robot2Power ? robot1 : robot2;
                }
        );
        System.out.println("Битва между " + robot1.name() + " и " + robot2.name() + " окончена!");
        return future;
    }

    public void shutdown() {
        executor.shutdown();
    }
}
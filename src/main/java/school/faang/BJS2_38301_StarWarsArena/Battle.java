package school.faang.BJS2_38301_StarWarsArena;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Battle {
    private static final int THREAD_POOL_SIZE = 3;

    private ExecutorService executor;

    public Battle() {
        executor = Executors.newFixedThreadPool(THREAD_POOL_SIZE);
    }

    public CompletableFuture<Robot> fight(Robot first, Robot second) {
        return CompletableFuture.supplyAsync(() -> {
            int firstRobotStats = first.getDefencePower() - first.getAttackPower();
            int secondRobotStats = second.getDefencePower() - second.getAttackPower();
            return firstRobotStats > secondRobotStats ? first : second;
        }, executor);
    }

    public void shutdownExecutor() {
        executor.shutdown();
    }
}

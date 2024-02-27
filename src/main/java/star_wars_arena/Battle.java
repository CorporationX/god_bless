package star_wars_arena;

import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Battle {
    private static final int NUM_THREADS = 2;
    public CompletableFuture<Optional<Robot>> battle(Robot robot1, Robot robot2) {
        ExecutorService executorService = Executors.newFixedThreadPool(NUM_THREADS);

        CompletableFuture<Integer> firstRobot = CompletableFuture.supplyAsync(() -> fightSimulation(robot1, robot2));
        CompletableFuture<Integer> secondRobot = CompletableFuture.supplyAsync(() -> fightSimulation(robot2, robot1));

        CompletableFuture<Void> combinedFuture = CompletableFuture.allOf(firstRobot, secondRobot);
        combinedFuture.join();

        CompletableFuture<Optional<Robot>> winner = firstRobot.thenCombine(secondRobot, (result1, result2) -> {
            if (result1 > result2) {
                return Optional.of(robot1);
            } else if (result1 < result2) {
                return Optional.of(robot2);
            } else {
                return Optional.empty();
            }
        });

        executorService.shutdown();

        return winner;
    }

    public int fightSimulation(Robot robot1, Robot robot2) {
        int result = 0;
        for (int i = 0; i < 5; i++) {
            result += robot1.getAttackPower() - robot2.getDefensePower();
        }
        return result;
    }
}

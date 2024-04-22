package faang.school.godbless.async.task_2.model;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Battle {
    private static final Random RANDOM = new Random();

    public Future<Robot> fight(Robot first, Robot second) {
        ExecutorService executor = Executors.newCachedThreadPool();
        Future<Robot> winner = executor.submit(() -> {
            int firstStats = (first.getAttackPower() + first.getDefensePower()) * RANDOM.nextInt(1, 20);
            int secondStats = second.getAttackPower() + second.getDefensePower() * RANDOM.nextInt(1, 20);
            return firstStats >= secondStats ? first : second;
        });
        executor.shutdown();
        return winner;
    }
}
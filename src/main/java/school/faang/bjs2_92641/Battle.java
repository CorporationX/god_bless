package school.faang.bjs2_92641;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadLocalRandom;

public class Battle {
    private final ExecutorService executor;

    public Battle(int thread) {
        executor = Executors.newFixedThreadPool(thread);
    }

    public Future<Robot> fight(Robot robotOne, Robot robotTwo) {
        return executor.submit(() -> {
            int score1 = robotOne.getAttackPower() - robotTwo.getDefensePower();
            int score2 = robotTwo.getAttackPower() - robotOne.getDefensePower();
            if (score1 > score2) {
                executor.shutdown();
                return robotOne;
            } else if (score2 > score1) {
                executor.shutdown();
                return robotTwo;
            } else {
                executor.shutdown();
                return ThreadLocalRandom.current().nextBoolean() ? robotOne : robotTwo;
            }
        });
    }
}

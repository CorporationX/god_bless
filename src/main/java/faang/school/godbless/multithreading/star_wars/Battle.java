package faang.school.godbless.multithreading.star_wars;

import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Battle {

    public Future<Robot> fight(Robot robot1, Robot robot2) {
        ExecutorService executor = Executors.newFixedThreadPool(2);

        Future<Robot> winner = executor.submit(() -> {
            int robot1Score = robot1.getAttackPower() - robot2.getDefencePower();
            int robot2Score = robot2.getAttackPower() - robot1.getDefencePower();

            try {
                Thread.sleep(new Random().nextInt(1000, 5000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            return robot1Score > robot2Score ? robot1 : robot2;
        });

        executor.shutdown();
        return winner;
    }
}

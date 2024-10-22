package school.faang.starwarsarena;

import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Battle {
    public Future<Robot> fight(Robot robot1, Robot robot2) {
        ExecutorService executor = Executors.newSingleThreadExecutor();

        Callable<Robot> battleTask = () -> determineWinner(robot1, robot2);

        Future<Robot> futureWinner = executor.submit(battleTask);

        executor.shutdown();

        return futureWinner;
    }

    private Robot determineWinner(Robot robot1, Robot robot2) {
        int score1 = robot1.getAttackPower() + robot1.getDefensePower();
        int score2 = robot2.getAttackPower() + robot2.getDefensePower();

        if (score1 > score2) {
            return robot1;
        } else if (score2 > score1) {
            return robot2;
        } else {
            return new Random().nextBoolean() ? robot1 : robot2;
        }
    }
}

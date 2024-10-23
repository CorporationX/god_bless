package school.faang.starwarsarena;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Battle {
    private final ExecutorService executor = Executors.newFixedThreadPool(2);

    public Future<Robot> fight(Robot robot1, Robot robot2) {
        return executor.submit(() -> calculateWinner(robot1, robot2));
    }

    public void executorShutDown() {
        executor.shutdown();
    }

    private Robot calculateWinner(Robot robot1, Robot robot2) {
        int totalPower1 = robot1.getAttackPower() + robot1.getDefensePower();
        int totalPower2 = robot2.getAttackPower() + robot2.getDefensePower();
        if (totalPower1 == totalPower2) {
            int random = new Random().nextInt(2) + 1;
            return random == 1 ? robot1 : robot2;
        }
        return totalPower1 > totalPower2 ? robot1 : robot2;
    }
}

package school.faang.starwarsarena;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Battle {

    private final ExecutorService executor = Executors.newCachedThreadPool();

    public Future<Robot> fight(Robot first, Robot second) {
        return executor.submit(() -> {

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            int firstRobotPower = first.getAttackPower() + first.getDefensePower();
            int secondRobotPower = second.getAttackPower() + second.getDefensePower();

            if (firstRobotPower > secondRobotPower) {
                return first;
            } else if (secondRobotPower > firstRobotPower) {
                return second;
            } else {
                return new Random().nextBoolean() ? first : second;
            }
        });
    }

    public void shutdown() {
        executor.shutdown();
    }
}

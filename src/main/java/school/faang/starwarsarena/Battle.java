package school.faang.starwarsarena;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Battle {
    public static final int NUM_THREADS = 5;
    public static final int TIME_OF_BATTLE = 1000;
    public static final ExecutorService executor = Executors.newFixedThreadPool(NUM_THREADS);

    public Future<Robot> fight(Robot firstRobot, Robot secondRobot) {
        return executor.submit(() -> {
            Thread.sleep(TIME_OF_BATTLE);
            int power1 = firstRobot.getAttackPower() + firstRobot.getDefensePower();
            int power2 = secondRobot.getAttackPower() + secondRobot.getDefensePower();
            int totalPower = power1 + power2;
            if (totalPower - power1 > totalPower - power2) {
                return firstRobot;
            } else if (totalPower - power2 > totalPower - power1) {
                return secondRobot;
            } else {
                Random random = new Random();
                Robot[] robots = {firstRobot, secondRobot};
                return robots[random.nextInt(robots.length)];
            }
        });
    }

    public void shutdown() {
        executor.shutdown();
    }
}

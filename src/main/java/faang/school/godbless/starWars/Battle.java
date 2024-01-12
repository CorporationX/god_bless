package faang.school.godbless.starWars;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class Battle {
    public Future<Robot> fight(Robot robot, Robot robot1) {
        ExecutorService executor = Executors.newFixedThreadPool(2);
        Future<Robot> winner = executor.submit(() -> {
            Robot robotWinner;
            int totalPowerRobot = robot.getAttackPower() + robot.getDefencePower();
            int totalPowerRobot1 = robot1.getAttackPower() + robot1.getDefencePower();
            if (totalPowerRobot > totalPowerRobot1) {
                robotWinner = robot;
            } else {
                robotWinner = robot1;
            }
            return robotWinner;
        });
        executor.shutdown();
        try {
            executor.awaitTermination(1, TimeUnit.MINUTES);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return winner;
    }
}

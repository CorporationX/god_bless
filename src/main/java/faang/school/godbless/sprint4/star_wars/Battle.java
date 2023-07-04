package faang.school.godbless.sprint4.star_wars;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Battle {
    public static Future<Robot> fight(Robot robot, Robot enemy) {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        Future<Robot> future = executorService.submit(() -> {
            robot.setDefensePower(robot.getDefensePower() - enemy.getAttackPower());
            enemy.setDefensePower(enemy.getDefensePower() - robot.getAttackPower());
            if (robot.getDefensePower() > enemy.getDefensePower()) {
                return robot;
            } else if (enemy.getDefensePower() > robot.getDefensePower()) {
                return enemy;
            } else {
                robot.setDefensePower(robot.getDefensePower() - enemy.getAttackPower());
                enemy.setDefensePower(enemy.getDefensePower() - robot.getAttackPower());
                if (robot.getDefensePower() > enemy.getDefensePower()) {
                    return robot;
                }
                if (enemy.getDefensePower() > robot.getDefensePower()) {
                    return enemy;
                }
                return null;
            }
        });
        executorService.shutdown();
        return future;
    }
}

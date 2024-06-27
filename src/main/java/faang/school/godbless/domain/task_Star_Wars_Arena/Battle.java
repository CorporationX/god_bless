package faang.school.godbless.domain.task_Star_Wars_Arena;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Battle {

    private ExecutorService executor = Executors.newSingleThreadExecutor();

    public Future<Robot> fight(Robot firstRobot, Robot secondRobot) {
        return executor.submit(() -> {
            System.out.println("Началась битва между " + firstRobot.name() + " и " + secondRobot.name());
            int firstRobotHealth = firstRobot.defensePower();
            int secondRobotHealth = secondRobot.defensePower();
            while (firstRobotHealth > 0 && secondRobotHealth > 0) {
                secondRobotHealth -= firstRobot.attackPower();
                System.out.println(firstRobot.name() + " Начал атаку " + secondRobot.name() + " .Здоровье " + secondRobot.name() + ": " + secondRobotHealth);
                if (secondRobotHealth > 0) {
                    firstRobotHealth -= secondRobot.attackPower();
                    System.out.println(secondRobot.name() + " Начал атаку " + firstRobot.name() + ".Здоровье " + firstRobot.name() + ": " + firstRobotHealth);
                }
            }
            if (firstRobotHealth > 0){
                return firstRobot;
            }return secondRobot;
        });
    }
}

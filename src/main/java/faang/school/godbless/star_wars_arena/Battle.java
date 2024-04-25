package faang.school.godbless.star_wars_arena;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Battle {

    public Future<Robot> fight(Robot robotFirst, Robot robotSecond) {

        ExecutorService executorService = Executors.newFixedThreadPool(5);

        int strRobotFirst = robotFirst.getAttackPower() + robotFirst.getDefensePower();
        int strRobotSecond = robotSecond.getAttackPower() + robotSecond.getDefensePower();

        Future<Robot> result = executorService.submit(() -> {
            System.out.println("Битва роботов: " + robotFirst.getName() + " и " + robotSecond.getName() + " началась");

            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            if (strRobotFirst > strRobotSecond) {
                return robotFirst;
            } else if (strRobotSecond > strRobotFirst) {
                return robotSecond;
            } else {
                throw new RuntimeException("Роботы равны по общей силе");
            }
        });
        executorService.shutdown();

        return result;
    }
}
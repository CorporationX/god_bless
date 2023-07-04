package faang.school.godbless.fourth.StarWars;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class Battle {
    public Future<Robot> fight(Robot robot1, Robot robot2) {
        ExecutorService service = Executors.newSingleThreadExecutor();

        Future<Robot> winner = service.submit(() -> findFightWinner(robot1, robot2));
        service.shutdown();

        try {
            service.awaitTermination(10, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            System.out.println("Thread has been interrupted");
            return null;
        }

        return winner;
    }

    private Robot findFightWinner(Robot robot1, Robot robot2) {
        int robot1TotalPower = robot1.attackPower() + robot1.defensePower();
        int robot2TotalPower = robot2.attackPower() + robot2.defensePower();
        if (robot1TotalPower > robot2TotalPower) {
            return robot1;
        } else if (robot1TotalPower == robot2TotalPower) {
            if (robot1.attackPower() > robot2.attackPower()) {
                return robot1;
            } else if (robot1.attackPower() == robot2.attackPower()) {
                return new Robot("Pile of broken metal", 0, 0);
            } else {
                return robot2;
            }
        } else {
            return robot2;
        }
    }
}

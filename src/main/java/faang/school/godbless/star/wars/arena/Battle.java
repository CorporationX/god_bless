package faang.school.godbless.star.wars.arena;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Battle {
    public Future<Robot> fight(Robot robot1, Robot robot2) {
        ExecutorService executor = Executors.newFixedThreadPool(2);
        Future<Robot> submit = executor.submit(() -> defineTheWinner(robot1, robot2));
        executor.shutdown();
        return submit;
    }

    private Robot defineTheWinner(Robot robot1, Robot robot2) {
        Robot winner = null;
        if (robot1.getAttackPower() > robot2.getAttackPower()) {
            winner = robot1;
        }
        if (robot1.getAttackPower() < robot2.getAttackPower()) {
            winner = robot2;
        }
        return winner;
    }
}

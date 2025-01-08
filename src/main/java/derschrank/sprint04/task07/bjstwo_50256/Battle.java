package derschrank.sprint04.task07.bjstwo_50256;

import lombok.extern.slf4j.Slf4j;

import java.util.Optional;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

@Slf4j
public class Battle implements BattleInterface {
    private static final int SIZE_OF_THREADPOOL = 10;
    private static final int TIME_TO_AWAIT_FOR_END_SEC = 30;
    private static final int TIME_TO_FIGHT_MILLIS = 1500;
    private final ExecutorService executor;
    private final Random rnd;

    public Battle() {
        executor = Executors.newFixedThreadPool(SIZE_OF_THREADPOOL);
        rnd = new Random();
    }

    @Override
    public Future<Fighting> fight(Robot robot1, Robot robot2) {
        return executor.submit(() -> fightingTask(robot1, robot2));
    }

    private Fighting fightingTask(Robot robot1, Robot robot2) {
        double pointsRobot1 = getOnlyPositivePoints(robot1.attackPower() - robot2.defensePower()) + getLuckPoint();
        double pointsRobot2 = getOnlyPositivePoints(robot2.attackPower() - robot1.defensePower()) + getLuckPoint();

        Robot winner;
        if (pointsRobot1 == pointsRobot2) {
            winner = null;
        } else if (pointsRobot1 > pointsRobot2) {
            winner = robot1;
        } else {
            winner = robot2;
        }

        toSleep(TIME_TO_FIGHT_MILLIS);
        Optional<Robot> winnerOptional = Optional.ofNullable(winner);
        return new Fighting(robot1, robot2, winnerOptional);
    }

    private double getLuckPoint() {
        return rnd.nextDouble(2);
    }

    private double getOnlyPositivePoints(double points) {
        if (points < 0) {
            return 0;
        }
        return points;
    }

    private void toSleep(int delay) {
        try {
            Thread.sleep(delay);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void endBattle() {
        executor.shutdown();
        try {
            executor.awaitTermination(TIME_TO_AWAIT_FOR_END_SEC, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            log.error("Battle was interrupted:\n" + e);
        }
    }

}

package school.faang.sprint4.task50555.model;

import lombok.extern.slf4j.Slf4j;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

@Slf4j
public class Battle {
    ExecutorService executor;

    public Battle(ExecutorService executor) {
        this.executor = executor;
    }

    public Future<Robot> fight(Robot robot1, Robot robot2, long battleTimeSec) {
        return executor.submit(() -> {
            int deltaRobot1 = robot1.getAttackPower() - robot1.getDefensePower();
            int deltaRobot2 = robot2.getAttackPower() - robot2.getDefensePower();
            int battleResult = deltaRobot1 - deltaRobot2;

            log.info("Battle between {} and {} will start now!", robot1.getName(), robot2.getName());

            try {
                Thread.sleep(battleTimeSec * 1000);
            } catch (InterruptedException e) {
                log.error("Thread was interrupted");
                Thread.currentThread().interrupt();
                throw new RuntimeException(e);
            }

            Robot robotWinner;
            if (battleResult > 0) {
                robotWinner = robot1;
            } else if (battleResult < 0) {
                robotWinner = robot2;
            } else {
                Random random = new Random();
                int num = random.nextInt(2);
                if (num == 0) {
                    robotWinner = robot1;
                } else {
                    robotWinner = robot2;
                }
            }
            log.info("Battle between {} and {} is finishes! Winner is {}",
                    robot1.getName(), robot2.getName(), robotWinner.getName());
            return robotWinner;
        });
    }
}

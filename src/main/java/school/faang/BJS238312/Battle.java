package school.faang.BJS238312;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

@Slf4j
public class Battle {
    private static final int THREADS = 3;
    private final ExecutorService executorService = Executors.newFixedThreadPool(THREADS);
    private static final int THREAD_SLEEP_TIME = 3000;

    public Future<Robot> fight(Robot fistRobot, Robot secondRobot) {
        int firstRobotPower = fistRobot.getAttackPower() + fistRobot.getDefensePower();
        int secondRobotPower = secondRobot.getAttackPower() + secondRobot.getDefensePower();
        return executorService.submit(() -> {
                threadSleep();
                if (firstRobotPower == secondRobotPower) {
                    return Math.random() > 0.50 ? fistRobot : secondRobot;
                } else {
                    return firstRobotPower > secondRobotPower ?  fistRobot : secondRobot;
                }
        });
    }

    public void threadSleep() {
        try {
            Thread.sleep(THREAD_SLEEP_TIME);
        } catch (InterruptedException e) {
            log.error("Something went wrong {}", e.getMessage());
        }
    }

    public void shutDown() {
        executorService.shutdown();
    }
}

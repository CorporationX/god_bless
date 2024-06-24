package faang.school.godbless.starwars_arena;

import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadLocalRandom;

@Slf4j
public class Battle {
    private static final int THREAD_NUM = 5;

    private final ExecutorService executorService = Executors.newFixedThreadPool(THREAD_NUM);

    public Future<Robot> fight(@NonNull Robot firstRobot,
                               @NonNull Robot secondRobot) {
        if (executorService.isShutdown()) {
            throw new RuntimeException("We are not accepting any candidates for battle anymore");
        }
        log.info("We have two candidates: " + firstRobot.getName() + " and " + secondRobot.getName());
        return executorService.submit(() -> getStrongestRobot(firstRobot, secondRobot));
    }

    public void closeCandidateAccept() {
        log.info("No candidates for battle anymore");
        executorService.shutdown();
    }

    private Robot getStrongestRobot(Robot firstRobot, Robot secondRobot) {
        int firstRobotPower = firstRobot.calculatePower();
        int secondRobotPower = secondRobot.calculatePower();

        try {
            log.info("Robots are fighting...");
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException("Someone has вмешался to the fighting: " + e.getMessage());
        }

        if (firstRobotPower > secondRobotPower) {
            return firstRobot;
        } else if (secondRobotPower > firstRobotPower) {
            return secondRobot;
        } else {
            boolean isFirstLucky = ThreadLocalRandom.current().nextBoolean();
            if (isFirstLucky) {
                return firstRobot;
            } else {
                return secondRobot;
            }
        }
    }
}

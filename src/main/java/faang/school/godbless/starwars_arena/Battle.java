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
    private static final int FIGHT_DURATION = 5000;

    private final ExecutorService executorService = Executors.newFixedThreadPool(THREAD_NUM);

    public Future<Robot> fight(@NonNull Robot firstRobot,
                               @NonNull Robot secondRobot) {
        if (executorService.isShutdown()) {
            throw new IllegalStateException("We are not accepting any candidates for battle anymore");
        }
        log.info("We have two candidates: {} and  {} ", firstRobot.getName(), secondRobot.getName());
        return executorService.submit(() -> determineWinner(firstRobot, secondRobot));
    }

    public void closeCandidateAccept() {
        log.info("No candidates for battle anymore");
        executorService.shutdown();
    }

    private Robot determineWinner(Robot firstRobot, Robot secondRobot) {
        int firstRobotPower = firstRobot.calculatePower();
        int secondRobotPower = secondRobot.calculatePower();

        log.info("Robots are fighting...");
        simulateFight();

        return comparePower(firstRobot, secondRobot, firstRobotPower, secondRobotPower);
    }

    private void simulateFight() {
        try {
            Thread.sleep(FIGHT_DURATION);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            log.error("The fight was interrupted: ", e);
        }
    }

    private Robot comparePower(Robot firstRobot, Robot secondRobot, int firstRobotPower, int secondRobotPower) {
        if (firstRobotPower > secondRobotPower) {
            return firstRobot;
        } else if (firstRobotPower < secondRobotPower) {
            return secondRobot;
        } else {
            return breakTie(firstRobot, secondRobot);
        }
    }

    private Robot breakTie(Robot firstRobot, Robot secondRobot) {
        boolean isFirstLucky = ThreadLocalRandom.current().nextBoolean();
        return isFirstLucky ? firstRobot : secondRobot;
    }
}

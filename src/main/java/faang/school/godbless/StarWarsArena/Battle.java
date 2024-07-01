package faang.school.godbless.StarWarsArena;

import lombok.extern.slf4j.Slf4j;

import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import static java.util.concurrent.TimeUnit.SECONDS;

@Slf4j
public class Battle {
    private static final int AWAIT_TERMINATION_TIME = 2;
    private static final Random random = new Random();
    private static final int NUM_THEADS = 3;
    private static final ExecutorService EXECUTOR = Executors.newFixedThreadPool(3);

    public Future<Robot> fight (Robot robotOne, Robot robotTwo) {
        attack(robotOne, robotTwo);

        CompletableFuture<Robot> result = CompletableFuture.supplyAsync(() -> {
            if (robotOne.getDefensePower() > 0 && robotTwo.getDefensePower() <= 0) {
                return robotOne;
            }
            if (robotOne.getDefensePower() <= 0 && robotTwo.getDefensePower() > 0) {
                return robotTwo;
            }
            return robotOne;
        }, EXECUTOR);

        EXECUTOR.shutdown();
        try {
            EXECUTOR.awaitTermination(AWAIT_TERMINATION_TIME, SECONDS);
        } catch (InterruptedException e) {
            log.error(".awaitTermination in fight method was interrupted while waiting");
            throw new RuntimeException(e);
        }

        return result;
    }

    public void attack(Robot robotOne, Robot robotTwo) {
        while (robotOne.getDefensePower() > 0 && robotTwo.getDefensePower() > 0) {
            robotOne.setDefensePower(robotOne.getDefensePower() - robotTwo.getAttackPower());
            robotTwo.setDefensePower(robotTwo.getDefensePower() - robotOne.getAttackPower());
        }
    }
}

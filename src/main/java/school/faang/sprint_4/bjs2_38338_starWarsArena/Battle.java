package school.faang.sprint_4.bjs2_38338_starWarsArena;

import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Slf4j
public class Battle {
    private static final Random RANDOM = new Random();
    private static final int THREADS_COUNT = 5;
    private final ExecutorService executor = Executors.newFixedThreadPool(THREADS_COUNT);

    public List<CompletableFuture<Void>> fightEveryone(List<Robot> robots) {
        return robots.stream()
                .map(firstRobot -> CompletableFuture.runAsync(() -> robots.stream()
                        .filter(secondRobot -> !firstRobot.equals(secondRobot))
                        .forEach(secondRobot -> CompletableFuture.allOf(fight(firstRobot, secondRobot))), executor))
                .toList();
    }

    private CompletableFuture<Robot> fight(Robot firstRobot, Robot secondRobot) {
        return CompletableFuture.supplyAsync(() -> compareTwoRobots(firstRobot, secondRobot), executor);
    }

    private Robot compareTwoRobots(Robot firstRobot, Robot secondRobot) {
        int firstPower = firstRobot.getAttackPower() + firstRobot.getDefencePower();
        int secondPower = secondRobot.getAttackPower() + secondRobot.getDefencePower();

        if (firstPower > secondPower) {
            logWinner(firstRobot, secondRobot);
            return firstRobot;
        } else if (secondPower > firstPower) {
            logWinner(secondRobot, firstRobot);
            return secondRobot;
        } else {
            return randomWinner(firstRobot, secondRobot);
        }
    }

    private Robot randomWinner(Robot firstRobot, Robot secondRobot) {
        Robot winner = RANDOM.nextBoolean() ? firstRobot : secondRobot;
        logWinner(winner, winner == firstRobot ? secondRobot : firstRobot);
        return winner;
    }

    private void logWinner(Robot winner, Robot loser) {
        log.info("{} beats {} and now has {} points!", winner.getName(), loser.getName(), winner.addPoint());
    }

    public void printResults(List<Robot> robots) {
        robots.forEach(robot -> log.info("'{}' has {} points.", robot.getName(), robot.getScore()));
    }

    public void shutdown() {
        executor.shutdown();
        try {
            if (!executor.awaitTermination(5, TimeUnit.SECONDS)) {
                log.info("Something went wrong! Shutting down immediately!");
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            log.error("An error occurred while thread shutting down now.", e);
            throw new IllegalStateException(e);
        }
    }
}

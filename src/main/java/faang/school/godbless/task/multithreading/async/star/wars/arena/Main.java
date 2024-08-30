package faang.school.godbless.task.multithreading.async.star.wars.arena;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.stream.IntStream;

@Slf4j
public class Main {
    private static final int NUMBER_OF_ROBOTS = 10;
    private static final int FIRST_ROBOT_ID = 1;
    private static final int SECOND_ROBOT_ID = 2;
    private static final int MAX_STATS = 10;
    private static final int MAX_CHAR = 90;
    private static final int MIN_CHAR = 65;

    private static final Random random = new Random();
    private static final Battle battle = new Battle();
    private static final List<Future<Robot>> futures = new ArrayList<>();
    private static List<Pair<Robot, Robot>> robots = getRobots();

    public static void main(String[] args) {
        startBattles();
        printResults();
        battle.getExecutor().shutdown();
    }

    private static void startBattles() {
        futures.addAll(startTask());
    }

    private static void printResults() {
        futures.forEach(future -> {
            try {
                Robot winner = future.get();
                log.info("Победитель битвы: {} ", winner.name());
            } catch (InterruptedException | ExecutionException e) {
                throw new RuntimeException(e);
            }
        });
    }

    private static List<Future<Robot>> startTask() {
        return robots
                .stream()
                .map(pare -> battle.fight(pare.first, pare.second))
                .toList();
    }

    private static List<Pair<Robot, Robot>> getRobots() {
        return IntStream
                .range(0, NUMBER_OF_ROBOTS / 2)
                .mapToObj(i -> getTwoRobots())
                .toList();
    }

    private static Pair<Robot, Robot> getTwoRobots() {
        return new Pair(new Robot("Robot " + getId() + FIRST_ROBOT_ID, getStat(), getStat()),
                new Robot("Robot " + getId() + SECOND_ROBOT_ID, getStat(), getStat()));
    }

    private static char getId() {
        return (char) (random.nextInt(MAX_CHAR - MIN_CHAR) + MIN_CHAR);
    }

    private static int getStat() {
        return random.nextInt(MAX_STATS - 1) + 1;
    }
}

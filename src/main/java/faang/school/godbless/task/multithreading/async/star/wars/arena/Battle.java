package faang.school.godbless.task.multithreading.async.star.wars.arena;

import lombok.extern.slf4j.Slf4j;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

@Slf4j
public class Battle {
    private static final int THREAD_POOL_SIZE = 5;

    private final ExecutorService executor = Executors.newFixedThreadPool(THREAD_POOL_SIZE);
    private final Random random = new Random();

    public Future<Robot> fight(Robot robotA, Robot robotB) {
        return executor.submit(() -> getWinner(robotA, robotB));
    }

    private Robot getWinner(Robot robotA, Robot robotB) {
        log.info("{} VS {}", robotA.name(), robotB.name());
        sleep();
        if (random.nextBoolean()) {
            return robotA;
        } else {
            return robotB;
        }
    }

    public void shutdownExecutor() {
        executor.shutdown();
    }

    private void sleep() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}

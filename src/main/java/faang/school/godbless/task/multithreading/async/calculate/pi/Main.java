package faang.school.godbless.task.multithreading.async.calculate.pi;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.stream.IntStream;

@Slf4j
public class Main {
    private static final int NUMBER_OF_POINTS = 10_000_000;
    private static final int THREAD_POOL_SIZE = 1000;

    private static final PiFinder piFinder = new PiFinder(THREAD_POOL_SIZE);
    private static final Random random = new Random();
    private static final List<CompletableFuture<Void>> futures = new ArrayList<>();
    private static List<Point> points = getPoints();

    public static void main(String[] args) {
        futures.addAll(runTask());
        printResult();
        piFinder.getExecutor().shutdown();
    }

    private static List<CompletableFuture<Void>> runTask() {
        return points
                .stream()
                .map(piFinder::allocatePoint)
                .toList();
    }

    private static void printResult() {
        CompletableFuture.allOf(futures.toArray(new CompletableFuture[0]))
                .thenRun(() -> log.info("Pi number ~ {}", piFinder.calculatePi()));
    }

    private static List<Point> getPoints() {
        return IntStream
                .range(0, NUMBER_OF_POINTS)
                .mapToObj(i -> new Point(getNumber(), getNumber()))
                .toList();
    }

    private static double getNumber() {
        return random.nextDouble();
    }
}

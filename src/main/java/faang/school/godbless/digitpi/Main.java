package faang.school.godbless.digitpi;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.IntStream;

public class Main {

    private static double inside;

    public static void main(String[] args) {
        System.out.println(calculatePi(100000));
    }

    public static double calculatePi(int n) {
        ExecutorService executorService = Executors.newFixedThreadPool(8);

        List<CompletableFuture<Point>> futureList = IntStream.range(0, n).parallel().mapToObj(
                (i) -> CompletableFuture.supplyAsync(
                        () -> new Point(
                                ThreadLocalRandom.current().nextDouble(0.0, 1.0),
                                ThreadLocalRandom.current().nextDouble(0.0, 1.0)
                        ), executorService
                )
        ).toList();

        executorService.shutdown();
        CompletableFuture.allOf(futureList.toArray(new CompletableFuture[]{}))
                .thenRun(() -> inside = futureList.stream()
                        .filter(point -> point.join().getSumPowCoordinates() <= 1.0)
                        .count()).join();

        return 4 * inside / n;
    }
}

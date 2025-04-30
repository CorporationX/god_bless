package school.faang.bjs2_74387;

import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.IntStream;

@Slf4j
public class Main {

    private static final int NUMBER_OR_POINTS = 10000000;

    public static void main(String[] args) {
        calculatePi();
    }

    private static void calculatePi() {
        List<CompletableFuture<Boolean>> points = IntStream.range(0, NUMBER_OR_POINTS)
                .boxed()
                .map(index ->
                        CompletableFuture.supplyAsync(Main::generateRandomPoint))
                .toList();

        CompletableFuture<Void> result = CompletableFuture.allOf(points.toArray(new CompletableFuture[0]));

        result.thenApply(v -> points.stream()
                        .filter(CompletableFuture::join)
                        .count())
                .thenAccept(inside -> log.info("pi -> {}", (double) (4 * inside) / NUMBER_OR_POINTS))
                .join();
    }

    private static boolean generateRandomPoint() {
        Point point = new Point(ThreadLocalRandom.current().nextDouble(0, 1),
                ThreadLocalRandom.current().nextDouble(0, 1));
        return point.isInsideCircle();
    }
}

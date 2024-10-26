package school.faang.number.pi;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

public class PiCalculator {
    private static final int NUM_OF_ALL_POINTS = 10000000;

    public static void main(String[] args) {
        System.out.println(calculatePi(NUM_OF_ALL_POINTS));
    }

    public static double calculatePi(int n) {
        AtomicInteger inside = new AtomicInteger(0);
        List<CompletableFuture<Void>> futures = IntStream.range(0, n).parallel()
                .mapToObj(i -> CompletableFuture.runAsync(() -> {
                    if (Point.generatePoint().isInsideCircle()) {
                        inside.incrementAndGet();
                    }
                }))
                .toList();
        return CompletableFuture.allOf(futures.toArray(new CompletableFuture[0]))
                .thenApply((voidRes) -> calculatePi(inside.get(), n))
                .join();
    }

    public static double calculatePi(int insidePointsCnt, int allPointsCnt) {
        return 4.0 * insidePointsCnt / allPointsCnt;
    }
}

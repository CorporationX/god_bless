package faang.school.godbless.BJS2_25049;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

public class Main {

    private static final int POINTS_COUNT = 1000000;

    public static void main(String[] args) {
        System.out.println("Pi = " + calculatePi());
    }

    static double calculatePi() {

        AtomicInteger insidePointsCounter = new AtomicInteger(0);

        List<CompletableFuture<Void>> futures = IntStream.range(0, Main.POINTS_COUNT)
                .mapToObj((i) -> CompletableFuture.runAsync(() -> {
                    Point point = new Point();
                    if (point.isInside()) {
                        insidePointsCounter.incrementAndGet();
                    }
                })).toList();

        CompletableFuture.allOf(futures.toArray(CompletableFuture[]::new)).join();

        return 4.0 * insidePointsCounter.get() / Main.POINTS_COUNT;
    }
}

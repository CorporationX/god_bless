package bjs2_62067;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ThreadLocalRandom;

@Slf4j
public class PiValueCalculator {
    public static double calculatePi(int n) {
        List<CompletableFuture<Boolean>> futures = new ArrayList<>(n);

        for (int i = 0; i < n; i++) {
            futures.add(CompletableFuture.supplyAsync(PiValueCalculator::generatePoint));
        }

        CompletableFuture.allOf(futures.toArray(new CompletableFuture[0])).join();

        var insideCount = futures.stream()
                .map(CompletableFuture::join)
                .filter(isInside -> isInside)
                .count();

        log.info("Внутри точек {} из {}", insideCount, n);

        return 4.0 * insideCount / n;
    }

    private static boolean generatePoint() {
        var random = ThreadLocalRandom.current();

        var x = random.nextDouble();
        var y = random.nextDouble();
        var point = new Point(x, y);

        return point.isInsideCircle();
    }
}

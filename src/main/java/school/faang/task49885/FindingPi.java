package school.faang.task49885;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.IntStream;

@Slf4j
public class FindingPi {
    private static final int SIDE_LENGTH_SQUARE = 1;
    private static final int MULTIPLIER_FOR_PI = 4;

    public double calculatePi(int countPoints) {
        if (countPoints < 1) {
            throw new IllegalArgumentException("Число точек не может быть меньше 1");
        }

        CompletableFuture<Long> countInside = CompletableFuture.supplyAsync(() -> IntStream.range(0, countPoints)
                .filter(i -> {
                    Point point = new Point(ThreadLocalRandom.current().nextDouble(SIDE_LENGTH_SQUARE),
                            ThreadLocalRandom.current().nextDouble(SIDE_LENGTH_SQUARE));

                    return isInsideCircle(point);
                })
                .count());

        return (double) (MULTIPLIER_FOR_PI * countInside.join()) / countPoints;
    }

    private boolean isInsideCircle(Point point) {
        return Math.pow(point.x(), 2) + Math.pow(point.y(), 2) <= 1;
    }
}

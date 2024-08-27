package faang.school.godbless.fourthsprint.pi;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.IntStream;

public class PiCalculator {
    private final static int NUM_POINTS = Integer.MAX_VALUE;

    public double calculatePi(int n) {
        CompletableFuture<Long> insideCircleFuture = CompletableFuture.supplyAsync(() ->
                IntStream.range(0, n)
                        .parallel()
                        .mapToObj(iteration -> generateRandomPoint())
                        .filter(Point::isInsideCircle)
                        .count()
        );

        long insideCircle = insideCircleFuture.join();

        return 4.0 * insideCircle / n;
    }

    private Point generateRandomPoint() {
        double x = ThreadLocalRandom.current().nextDouble();
        double y = ThreadLocalRandom.current().nextDouble();
        return new Point(x, y);
    }

    public static void main(String[] args) {
        PiCalculator calculator = new PiCalculator();
        double pi = calculator.calculatePi(NUM_POINTS);
        System.out.println("Calculated value of Pi: " + pi);
    }
}

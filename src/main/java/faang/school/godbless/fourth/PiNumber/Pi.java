package faang.school.godbless.fourth.PiNumber;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ThreadLocalRandom;

public class Pi {
    public static double calculatePi(int n) {
        List<CompletableFuture<Point>> futures = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            futures.add(CompletableFuture.supplyAsync(Pi::calculatePointCoordinates));
        }

        double pointInsideCircle = futures.stream()
                .map(future -> Math.pow(future.join().x(), 2) + Math.pow(future.join().y(), 2) <= 1)
                .filter(Boolean::booleanValue)
                .count();

        return 4 * pointInsideCircle / futures.size();
    }

    public static Point calculatePointCoordinates() {
        double x = ThreadLocalRandom.current().nextDouble();
        double y = ThreadLocalRandom.current().nextDouble();
        return new Point(x, y);
    }

    public static void main(String[] args) {
        System.out.println(Pi.calculatePi(100_000));
    }
}

package school.faang.calculatingPhi;

import lombok.RequiredArgsConstructor;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.atomic.AtomicInteger;

@RequiredArgsConstructor
public class Circle {
    private final double radius;
    private final AtomicInteger inside = new AtomicInteger(0);

    public boolean checkIfInside(Point coordinates) {
        return Math.pow(coordinates.getX(), 2) + Math.pow(coordinates.getY(), 2) <= Math.pow(radius, 2);
    }

    public double calculatePhi(int n) {
        CompletableFuture.runAsync(() -> {
            for (int i = 0; i < n; i++) {
                Point point = Point.generateRandomPoint(radius);
                if (checkIfInside(point)) {
                    inside.getAndIncrement();
                }
            }
        }).join();
        return 4.0 * inside.get() / n;
    }
}

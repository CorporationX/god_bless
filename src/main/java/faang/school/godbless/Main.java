package faang.school.godbless;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class Main {
    public static void main(String[] args) {
        System.out.println(findPi(1, 1500));
    }

    public static double findPi(double radius, int pointsQuantity) {
        List<CompletableFuture<Point>> futures = new ArrayList<>();
        double pointsInside = 0;
        double allPoints = 0;

        for (int i = 0; i < pointsQuantity; i++) {
            futures.add(CompletableFuture.supplyAsync(() -> {
                return Point.generatePoint();
            }));
        }
        CompletableFuture.allOf(futures.toArray(new CompletableFuture[0])).join();

        for (CompletableFuture<Point> future : futures) {
            Point tempPoint;
            try {
                tempPoint = future.get();
            } catch (InterruptedException | ExecutionException e) {
                throw new RuntimeException(e);
            }
            if (Math.pow(tempPoint.getX(), 2) + Math.pow(tempPoint.getY(), 2) <= Math.pow(radius, 2)) {
                pointsInside++;
            }
            allPoints++;
        }

        return 4 * pointsInside / allPoints;
    }
}

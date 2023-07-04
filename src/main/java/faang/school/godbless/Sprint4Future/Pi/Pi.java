package faang.school.godbless.Sprint4Future.Pi;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.atomic.AtomicInteger;

public class Pi {
    private AtomicInteger allInside = new AtomicInteger(0);

    public static void main(String[] args) {
        Pi pi = new Pi();
        System.out.println(pi.calculatePi(10000));
    }

    public double calculatePi(int n) {
        int insidePoints = 0;
        List<CompletableFuture<Integer>> futureList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            futureList.add(makePoints());
        }
        CompletableFuture<Void> completableFutures = CompletableFuture
                .allOf(futureList.toArray(new CompletableFuture[futureList.size()]));
        completableFutures.join();
        insidePoints = allInside.get();
        int allPoints = n * 10000;
        return (4 * insidePoints) / (double) allPoints;
    }

    private CompletableFuture<Integer> makePoints() {
        List<Point> points = new ArrayList<>();
        return CompletableFuture.supplyAsync(() -> {
            for (int i = 0; i < 10000; i++) {
                double x = ThreadLocalRandom.current().nextDouble(0, 1);
                double y = ThreadLocalRandom.current().nextDouble(0, 1);
                points.add(new Point(x, y));
            }
            int inside = 0;
            for (Point point : points) {
                double insideFormula = point.x() * point.x() + point.y() * point.y();
                if (insideFormula <= 1) {
                    inside++;
                }
            }
            allInside.addAndGet(inside);
            return inside;
        });
    }
}

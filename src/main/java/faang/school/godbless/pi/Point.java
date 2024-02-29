package faang.school.godbless.pi;


import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.locks.ReentrantLock;

public class Point {
    private final double a;
    private final double b;

    private ReentrantLock lock = new ReentrantLock(true);

    public Point(double a, double b) {
        this.a = a;
        this.b = b;
    }

    public Point() {
        this(ThreadLocalRandom.current().nextDouble(), ThreadLocalRandom.current().nextDouble());
    }

    public double getA() {
        return a;
    }

    public double getB() {
        return b;
    }

    public static List<Point> generateRandomPoints(int numberOfPoints) {
        List<CompletableFuture<Point>> futureResult = new ArrayList<>();
        for (int i = 0; i < numberOfPoints; i++) {
            futureResult.add(CompletableFuture.supplyAsync(() -> new Point()));
        }
        CompletableFuture.allOf(futureResult.toArray(CompletableFuture[]::new)).join();
        return futureResult.stream()
                .map(point -> {
                    try {
                        return point.get();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    } catch (ExecutionException e) {
                        throw new RuntimeException(e);
                    }
                })
                .toList();
    }
}



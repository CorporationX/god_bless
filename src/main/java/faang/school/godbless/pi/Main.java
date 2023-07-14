package faang.school.godbless.pi;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ThreadLocalRandom;

public class Main {
    private final static int RADIUS = 1;

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        System.out.println("Число Пи = " + calculatePi(100000));
    }

    private static double calculatePi(int j) throws ExecutionException, InterruptedException {
        ThreadLocalRandom random = ThreadLocalRandom.current();
        List<Point> allPoints = new ArrayList<>();

        for (int i = 0; i < j; i++) {
            CompletableFuture<Double> futureX = CompletableFuture.supplyAsync(random::nextDouble);
            CompletableFuture<Double> futureY = CompletableFuture.supplyAsync(random::nextDouble);
            allPoints.add(new Point(futureX.get(), futureY.get()));
        }

        List<Point> inside = new ArrayList<>(allPoints.stream()
                .filter((point) -> Math.pow(point.getX(), 2) + Math.pow(point.getY(), 2) <= Math.pow(RADIUS, 2))
                .toList());
        return (double)4 * inside.size()/allPoints.size();
    }
}

package faang.school.godbless.sprint5.Multithreading_Async.task13_PI;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ThreadLocalRandom;

public class GreatPi {

    private final int countIterate = 10_000_000;

    public double createPi(int numberOfMillionthIterations) {
        List<CompletableFuture<Integer>> futures = new ArrayList<>();
        for (int i = 0; i < numberOfMillionthIterations; i++) {
            futures.add(ggg());
        }

        CompletableFuture<Void> voidCompletableFuture = CompletableFuture.allOf(futures.toArray(new CompletableFuture[futures.size()]));
        CompletableFuture<Integer> integerCompletableFuture = voidCompletableFuture.thenApply(s -> {
            int sum = futures.stream()
                    .mapToInt(x -> {
                        try {
                            return x.get();
                        } catch (InterruptedException | ExecutionException e) {
                            throw new RuntimeException(e);
                        }
                    })
                    .sum();
            return sum;
        });
        Integer inside;
        try {
            inside = integerCompletableFuture.get();
        } catch (InterruptedException | ExecutionException e) {
            throw new RuntimeException(e);
        }
        double all = (double) numberOfMillionthIterations * countIterate;
        return 4 * inside / all;
    }

    public CompletableFuture<Integer> ggg() {
        return CompletableFuture.supplyAsync(() -> {
            int inside = 0;
            for (int i = 0; i < countIterate; i++) {
                if (checkPointInside(createPoint())) {
                    inside++;
                }
            }
            return inside;
        });
    }

    public boolean checkPointInside(Point point) {
        double x = point.getX();
        double y = point.getY();
        double r = x * x + y * y;
        return r <= 1;
    }


    public Point createPoint() {
        return new Point(generateRandomNumber(), generateRandomNumber());
    }

    private double generateRandomNumber() {
        ThreadLocalRandom random = ThreadLocalRandom.current();
        return random.nextDouble(0, 1);
    }


}

package faang.school.godbless.CalculatePi;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ThreadLocalRandom;

public class CalculatePi {
    public static void main(String[] args) {
        System.out.println(calculatePi(1000000));
    }

    public static double calculatePi(int n) {
        List<CompletableFuture<Point>> futures = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            futures.add(CompletableFuture.supplyAsync(() ->
                    new Point(randomDouble(), randomDouble())));
        }

        CompletableFuture.allOf(futures.toArray(new CompletableFuture[0])).join();

        int inside = 0;
        int all = 0;
        for (CompletableFuture<Point> future : futures) {
            double x;
            double y;
            try {
                x = future.get().getX();
                y = future.get().getY();
            } catch (InterruptedException | ExecutionException e) {
                throw new RuntimeException(e);
            }
            if (x * x + y * y <= 1) {
                inside++;
            }
            all++;
        }

        return 4.0 * inside / all;
    }

    public static double randomDouble() {
        return ThreadLocalRandom.current().nextDouble(1.0);
    }
}

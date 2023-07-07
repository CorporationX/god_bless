package numberPi;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.atomic.AtomicInteger;

@Data
public class NumberPi {
    private static int inside;
    private final int R = 1;

    @Data
    public static class Point {
        public double x = new Random().nextDouble(1);
        public double y = new Random().nextDouble(1);
    }

    public static double calculatePi(int n) throws ExecutionException, InterruptedException {
        CompletableFuture.supplyAsync(() -> {
            for (int i = 0; i < n; i++) {
                Point future = new Point();
                if (future.getX() * future.getX() + future.getY() * future.getY() <= 1) {
                    inside++;
                }
            }
            return inside;
        }).join();
        return (double) (4 * inside) / n;
    }

    public static void main(String[] args) {
        int boundedRandomValue = ThreadLocalRandom.current().nextInt(10000, 1000000);
        try {
            System.out.println(boundedRandomValue);
            System.out.println(calculatePi(boundedRandomValue));
        } catch (ExecutionException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}

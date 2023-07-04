package Sprint_4_1_Task13;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ThreadLocalRandom;

public class CalculateTheNumberOfPI {

    public static double calculatePi(int inside) {
        int all = CompletableFuture.supplyAsync(() -> {
            System.out.println(Thread.currentThread().getName() + " Pi: ");
            int count = 0;
            for (int i = 0; i < inside; i++) {
                Point point = point();
                if (point.circleInequality()) {
                    count++;
                }
            }
            return count;
        }).join();
        return all / (double) inside * 4;

    }

    public static Point point() {
        double x = random();
        double y = random();
        return new Point(x, y);
    }

    public static double random() {
        ThreadLocalRandom random = ThreadLocalRandom.current();
        return random.nextDouble(0, 1);
    }
}

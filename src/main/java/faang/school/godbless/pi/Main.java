package faang.school.godbless.pi;

import java.util.concurrent.CompletableFuture;

public class Main {
    public static void main(String[] args) {
        int n = 1000000;

        double pi = calculatePi(n);
        System.out.println("Аппроксимация π: " + pi);
    }


    public static double calculatePi(int n) {

        @SuppressWarnings("unchecked")
        CompletableFuture<Point>[] futures = new CompletableFuture[n];

        for (int i = 0; i < n; i++) {
            futures[i] = CompletableFuture.supplyAsync(Point::generate);
        }

        CompletableFuture<Void> allFutures = CompletableFuture.allOf(futures);

        int insideCount = allFutures.thenApply(ignored -> {
            int count = 0;
            for (CompletableFuture<Point> future : futures) {
                Point point = future.join();
                if (point.isInsideCircle()) {
                    count++;
                }
            }
            return count;
        }).join();

        return 4.0 * insideCount / n;
    }

}

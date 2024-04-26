package faang.school.godbless.bjs2_5949;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

public class Main {

    public static void main(String[] args) {
        double pi = calculatePi(10000000);
        System.out.println("Pi is: " + pi);
    }

    public static double calculatePi(int n) {
        ExecutorService executorService = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());

        List<CompletableFuture<Point>> futures = IntStream.range(0, n)
                .mapToObj(num -> CompletableFuture.supplyAsync(() -> {
                    double x = ThreadLocalRandom.current().nextDouble(0.0, 1.0);
                    double y = ThreadLocalRandom.current().nextDouble(0.0, 1.0);
                    return new Point(x, y);
                })).toList();

        CompletableFuture.allOf(futures.toArray(new CompletableFuture[0])).join();

        long inside = futures.stream()
                .map(CompletableFuture::join)
                .filter(point -> (Math.pow(point.getX(), 2) + Math.pow(point.getY(), 2)) <= 1).count();

        executorService.shutdown();
        try {
            while (!executorService.awaitTermination(1, TimeUnit.MINUTES)) {
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return 4.0 * inside / futures.size();
    }
}

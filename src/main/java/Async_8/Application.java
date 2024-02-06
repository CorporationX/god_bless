package Async_8;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Application {

    private static ExecutorService service = Executors.newFixedThreadPool(4);

    private static float calculatePi(int pointCount) {
        List<CompletableFuture<Point>> completableFutures = new ArrayList<>();
        for (int i = 0; i < pointCount; i++) {
            completableFutures.add(CompletableFuture.supplyAsync(() -> new Point(), service));
        }
        long inside = completableFutures
                .stream()
                .map(n -> n.join())
                .filter(n -> (n.getyO() * n.getyO()) + (n.getxO() * n.getxO()) <= 1)
                .count();
        service.shutdown();
        return (float) 4 * inside / completableFutures.size();
    }

    public static void main(String[] args) {
        System.out.println("Pi: " + calculatePi(1000000));
    }
}

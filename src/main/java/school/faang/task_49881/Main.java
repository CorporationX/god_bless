package school.faang.task_49881;

import java.util.concurrent.*;

public class Main {
    private static final int NUMBER_OF_POINTS = 1000000;

    public static void main(String[] args) throws InterruptedException {
        int tasks = Runtime.getRuntime().availableProcessors();
        ExecutorService executorService = Executors.newFixedThreadPool(tasks);
        Point point = new Point();

        double pi = calculatePi(NUMBER_OF_POINTS, executorService);
        System.out.println("pi: " + pi);

        if (!executorService.awaitTermination(20, TimeUnit.SECONDS)) {
            executorService.shutdown();
        }
    }

    public static int calculatePi(int n, ExecutorService executorService) {
        CompletableFuture<Void>[] tasks = new CompletableFuture[n];

        for (int i = 0; i < n; i++) {
            tasks[i] = CompletableFuture.runAsync(() -> {
                Point point = new Point();
                float coordX = ThreadLocalRandom.current().nextFloat(1);
                float coordy = ThreadLocalRandom.current().nextFloat(1);
                point.setCoordinateX(coordX);
                point.setCoordinateY(coordy);
                if (point.isInsideCircle()) {
                    Point.getInsidePoints().add(point);
                }
            }, executorService);
        }

        CompletableFuture.allOf(tasks).join();

        int sizeOfInsidePoints = Point.getInsidePoints().size();
        return (4 * sizeOfInsidePoints) / n;
    }
}
package faang.school.godbless.piCalculator;

import java.util.List;
import java.util.concurrent.*;
import java.util.stream.IntStream;

public class PiCalculator {
    public static double calculatePi(int n) {
        ExecutorService executorService = Executors.newFixedThreadPool(Math.min(n, 8));

        List<CompletableFuture<Point>> futurePoints = IntStream.range(0, n).parallel().mapToObj(
                (i) -> CompletableFuture.supplyAsync(
                        () -> {
                            double x = ThreadLocalRandom.current().nextDouble(0.0, 1.0);
                            double y = ThreadLocalRandom.current().nextDouble(0.0, 1.0);
                            return new Point(x, y);
                        },
                        executorService
                )
        ).toList();

        int insidePointsCount = futurePoints.parallelStream()
                .map(futurePoint -> {
                    try {
                        return futurePoint.get();
                    } catch (InterruptedException | ExecutionException e) {
                        throw new RuntimeException(e);
                    }
                }).peek(point -> {
                    if (Math.pow(point.getX(), 2) + Math.pow(point.getY(), 2) <= 1) {
                        point.setInside(true);
                    }
                }).map(point -> {
                    if (point.isInside()) {
                        return 1;
                    } else {
                        return 0;
                    }
                }).reduce(0, Integer::sum);

        closeExecutorService(executorService);

        return 4.0 * insidePointsCount / futurePoints.size();
    }

    private static void closeExecutorService(ExecutorService executorService) {
        executorService.shutdown();
        try {
            if (!executorService.awaitTermination(2, TimeUnit.MINUTES)) {
                executorService.shutdownNow();
            }
        } catch (InterruptedException e) {
            executorService.shutdownNow();
        }
    }

    public static void main(String[] args) {
        //Результат точный до десятых
        System.out.println(calculatePi(1500));
        System.out.println(Math.PI);
    }
}

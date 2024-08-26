package faang.school.godbless.piCalculator;

import java.util.List;
import java.util.concurrent.*;
import java.util.stream.IntStream;

public class PiCalculator {
    public static double calculatePi(int n) {
        ExecutorService executorService = Executors.newFixedThreadPool(Math.min(n, 8));

        //Асинхронно считаем координаты n точек
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

        //получаем результат - список точек и проверяем их на принадлежность к единичной окружности
        List<Point> points = futurePoints.parallelStream()
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
                }).toList();

        int insidePointsCount = points.stream().map(point -> {
            if (point.isInside()) {
                return 1;
            } else {
                return 0;
            }
        }).reduce(0, Integer::sum);

        int allPointsCount = points.size();

        executorService.shutdown();
        try {
            if (!executorService.awaitTermination(2, TimeUnit.MINUTES)) {
                executorService.shutdownNow();
            }
        } catch (InterruptedException e) {
            executorService.shutdownNow();
        }

        return 4.0 * insidePointsCount / allPointsCount;
    }

    public static void main(String[] args) {
        //Результат точный до десятых
        System.out.println(calculatePi(1500));
        System.out.println(Math.PI);
    }
}

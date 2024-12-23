package school.faang.task_49881;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadLocalRandom;

@Data
public class Point {
    private float coordinateX;
    private float coordinateY;
    private static List<Point> insidePoints = new ArrayList<>();

    public boolean isInsideCircle() {
        return Math.pow(coordinateX, 2) + Math.pow(coordinateY, 2) <= 1;
    }

    public int calculatePi(int n, ExecutorService executorService) {
        CompletableFuture<Void>[] tasks = new CompletableFuture[n];

        for (int i = 0; i < n; i++) {
            tasks[i] = CompletableFuture.runAsync(() -> {
                Point point = new Point();
                float coordX = ThreadLocalRandom.current().nextFloat(1);
                float coordy = ThreadLocalRandom.current().nextFloat(1);
                point.setCoordinateX(coordX);
                point.setCoordinateY(coordy);
                if (point.isInsideCircle()) {
                    insidePoints.add(point);
                }
            }, executorService);
        }

        CompletableFuture.allOf(tasks).join();

        return (4 * insidePoints.size()) / n;
    }
}

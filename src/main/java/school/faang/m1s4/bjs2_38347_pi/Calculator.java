package school.faang.m1s4.bjs2_38347_pi;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Slf4j
public class Calculator {
    private static final int N_POINTS = 35_000_000;
    private static final double LOWER_BOUND = 0.99999;
    private static final double UPPER_BOUND = 1.00001;
    private static final int N_POOLS = 20;
    private final ExecutorService service = Executors.newFixedThreadPool(N_POOLS);
    private final Set<Point> points = ConcurrentHashMap.newKeySet();

    public void calculatePi() {
        createPointsSet();
        double pi = calculateCircumference() * 2;
        System.out.println(Math.PI + " : Real Pi");
        System.out.println(pi + " : Calculated Pi");
        System.out.println((Math.PI - pi) + " : difference");
    }

    private void createPointsSet () {
        List<CompletableFuture<Void>> allTasks = new ArrayList<>();
        for (int i = 0; i < N_POINTS; i++) {
            CompletableFuture<Void> task = CompletableFuture.runAsync(() -> {
                Point point = new Point();
                double distance = point.calculateDistanceFromCenter();
                if(distance > LOWER_BOUND && distance < UPPER_BOUND) {
                    points.add(point);
                }
            },service);
            allTasks.add(task);
        }
        CompletableFuture.allOf(allTasks.toArray(new CompletableFuture[0])).join();
        shutdownPool();
    }

    private List<Point> sortTransformSetToList() {
        return points.stream()
                .sorted(Comparator.comparingDouble(Point::getX))
                .toList();
    }

    private double calculateCircumference() {
        log.info("start");
        List<Point> pointsList = sortTransformSetToList();
        double result = 0;
        for (int i = 1; i < pointsList.size(); i++) {
            Point previousPoint = pointsList.get(i - 1);
            Point currentPoint = pointsList.get(i);
            result += currentPoint.calculateDistanceFromOtherPoint(previousPoint);
        }
        log.info("end");
        return result;
    }

    private void shutdownPool() {
        service.shutdown();
        try {
            if(!service.awaitTermination(300, TimeUnit.SECONDS)) {
                service.shutdownNow();
            }
        } catch (InterruptedException e) {
            log.error("Thread has been interrupted", e);
        }
    }
}

package faang.school.godbless.Task_Calculating_Pi;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

public class Calculator {

    private final static List<Point> circlePoints = new ArrayList<>();
    private final static List<Point> allPoints = new ArrayList<>();

    public static double calculatePi(int n) {
        int k = getThreadNumber(n);
        ExecutorService evaluator = Executors.newFixedThreadPool(k);
        IntStream.range(0, k).parallel().mapToObj((x) -> CompletableFuture.supplyAsync((Point::new), evaluator)
                .thenAccept((point) -> {
                    if (point.checkIfInside()) {
                        circlePoints.add(point);
                        allPoints.add(point);
                    } else allPoints.add(point);
                })).forEach(CompletableFuture::join);
        evaluator.shutdown();
        return (double) (4 * circlePoints.size()) / allPoints.size();
    }

    public static int getThreadNumber(int n) {
        if (n < 6) return 8;
        else return Math.min(n, 8);
    }
}

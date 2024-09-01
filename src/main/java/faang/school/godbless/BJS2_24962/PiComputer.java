package faang.school.godbless.BJS2_24962;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

import static java.lang.Math.pow;

public class PiComputer {
    private final PointMaker maker = new PointMaker();
    private final AtomicInteger insidePoints = new AtomicInteger(0);

    public double calculatePi(int n) {
        List<CompletableFuture<Void>> futures = IntStream.range(0, n)
                .mapToObj(i -> CompletableFuture.runAsync(this::computePoint))
                .toList();

        CompletableFuture.allOf(futures.toArray(CompletableFuture[]::new)).join();
        return 4 * (double) insidePoints.get() / n;
    }

    private void computePoint() {
        Point point = maker.generatePoint();
        if (pow(point.getX(), 2) + pow(point.getY(), 2) <= 1) {
            insidePoints.incrementAndGet();
        }
    }

    public static void main(String[] args) {
        PiComputer piComputer = new PiComputer();
        double pi = piComputer.calculatePi(100000000);
        System.out.println(pi);
    }
}

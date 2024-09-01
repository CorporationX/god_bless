package faang.school.godbless.BJS2_25127;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class Main {
    private static final int radius = 1;
    private static final int aSqure = 1;

    private double areaCircle;
    private double areaSquare;

    public static double calculatePi(int n) {
        List<Pair> coords = new ArrayList<>();

        for(int i = 0; i < n; i++) {
            double x = Math.round(Math.random() * 10) / 10.0;
            double y = Math.round(Math.random() * 10) / 10.0;
            coords.add(new Pair(x, y));
        }

        AtomicInteger inside = new AtomicInteger();
        int all = coords.size();

        List<CompletableFuture<Void>> futures = coords.stream()
                .map(pair -> CompletableFuture.runAsync(()
                        -> {
                    if((pair.getX() * pair.getX() + pair.getY() * pair.getY()) < radius) {
                        inside.incrementAndGet();
                    }
                }))
                .collect(Collectors.toList());

        CompletableFuture.allOf(futures.toArray(new CompletableFuture[0])).join();

        return 4.0 * inside.get() / all;
    }
    public static void main(String[] args) {
        System.out.println(calculatePi(1000));
    }

}

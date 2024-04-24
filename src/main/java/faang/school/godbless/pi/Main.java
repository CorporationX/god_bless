package faang.school.godbless.pi;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

public class Main {

    public static void main(String[] args) {
        System.out.println(calculatePi(10_000_000));
    }

    public static double calculatePi(int n) {

        ExecutorService service = Executors.newFixedThreadPool(Math.min(n, 6));
        AtomicInteger inside = new AtomicInteger();
        AtomicInteger all = new AtomicInteger();

        List<CompletableFuture<Point>> futures = IntStream.range(0, n).mapToObj((number) -> CompletableFuture.supplyAsync(() -> {
            double x = ThreadLocalRandom.current().nextDouble(0, 1);
            double y = ThreadLocalRandom.current().nextDouble(0, 1);
            all.incrementAndGet();
            if(Math.pow(x, 2) + Math.pow(y,2) <= 1){
                inside.incrementAndGet();
            }
            return new Point(x, y);
        }, service)).toList();

        CompletableFuture.allOf(futures.toArray(new CompletableFuture[0])).join();

        service.shutdown();

        System.out.println(all + " " + inside.get());
        return 4.0 * inside.get() / all.get();
    }
}

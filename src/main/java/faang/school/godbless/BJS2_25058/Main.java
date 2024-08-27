package faang.school.godbless.BJS2_25058;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {

    }

    static double calculatePi(int n) {
        // Берём минимум, что бы не создать слишком много потоков
        ExecutorService service = Executors.newFixedThreadPool(Math.min(n, 8));

        IntStream.range(0, n).parallel().mapToObj(
                (i) -> CompletableFuture.supplyAsync(
                        () -> {
                            double x = ThreadLocalRandom.current().nextDouble(0.0, 1.0);
                            double y = ThreadLocalRandom.current().nextDouble(0.0, 1.0);
                        },
                        service
                )
        )
    }
}

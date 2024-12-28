package school.faang.sprint_4.task_49884;

import lombok.extern.slf4j.Slf4j;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadLocalRandom;

@Slf4j
public class PiCalculator {
    private static final int BATCH_SIZE = 100_000_000;

    public static BigDecimal calculate(long amountOfPoints, ExecutorService executorService) {

        List<CompletableFuture<Long>> batchFutures = new ArrayList<>();
        long totalBatches = (amountOfPoints + BATCH_SIZE - 1) / BATCH_SIZE;

        for (int batch = 0; batch < totalBatches; batch++) {
            int finalBatch = batch;
            batchFutures.add(CompletableFuture.supplyAsync(() -> {
                long insideCircle = 0;
                ThreadLocalRandom random = ThreadLocalRandom.current();

                for (int i = 0; i < BATCH_SIZE && ((long) finalBatch * BATCH_SIZE + i) < amountOfPoints; i++) {
                    Point point = new Point(random.nextDouble(), random.nextDouble());
                    if (point.isInsideCircle()) {
                        insideCircle++;
                    }
                }
                log.info("inside circle: {}, batchNumber {}", insideCircle, finalBatch);
                return insideCircle;
            }, executorService));
        }

        long totalInside = batchFutures.stream()
                .map(CompletableFuture::join)
                .reduce(0L, Long::sum);

        return BigDecimal.valueOf(4).multiply(
                BigDecimal.valueOf(totalInside).divide(
                        BigDecimal.valueOf(amountOfPoints), 10, RoundingMode.HALF_UP));
    }
}

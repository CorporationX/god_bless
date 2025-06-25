package school.faang.bjs2_82551;

import lombok.extern.slf4j.Slf4j;

import java.math.BigInteger;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ThreadLocalRandom;

import static school.faang.bjs2_82551.FactorialCalculator.MAX_INT_FACTORIAL;
import static school.faang.bjs2_82551.FactorialCalculator.MAX_LONG_FACTORIAL;

@Slf4j
public class Main {
    private static final ThreadLocalRandom RANDOM = ThreadLocalRandom.current();

    public static void main(String[] args) {
        List<Integer> nums = List.of(0, 1,
                                     RANDOM.nextInt(MAX_INT_FACTORIAL),
                                     RANDOM.nextInt(MAX_INT_FACTORIAL + 1, MAX_LONG_FACTORIAL),
                                     RANDOM.nextInt(MAX_LONG_FACTORIAL + 1, MAX_INT_FACTORIAL + MAX_LONG_FACTORIAL));
        CountDownLatch latch = new CountDownLatch(nums.size());

        List<CompletableFuture<BigInteger>> futures = FactorialCalculator.factorials(nums);

        for (int i = 0; i < nums.size(); i++) {
            int finalIndex = i;
            futures.get(i)
                    .whenCompleteAsync((factorial, exc) -> {
                        if (exc != null) {
                            log.error("Ошибка при вычислении факториала {}", nums.get(finalIndex), exc);
                            latch.countDown();
                        } else {
                            log.info("!{}={}", nums.get(finalIndex), factorial);
                            latch.countDown();
                        }
                    });
        }

        try {
            latch.await();
            log.info("Факториалы всех чисел рассчитаны");
        } catch (InterruptedException e) {
            log.info("Поток был прерван", e);
            Thread.currentThread().interrupt();
        }
    }
}

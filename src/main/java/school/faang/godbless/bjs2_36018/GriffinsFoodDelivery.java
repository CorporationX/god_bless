package school.faang.godbless.bjs2_36018;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

@Slf4j
public class GriffinsFoodDelivery {
    private static final int THREADS_NUMBER = 3;
    private static final String[] CHARACTER_NAMES = {"Peter", "Lois", "Meg", "Chris", "Stewie"};
    private static final int MIN_AMOUNT = 5;
    private static final int MAX_AMOUNT = 30;

    public static void main(String[] args) {
        ExecutorService pool = Executors.newFixedThreadPool(THREADS_NUMBER);
        Arrays.stream(CHARACTER_NAMES).forEach(name ->
                pool.submit(new FoodDeliveryTask(name,
                        ThreadLocalRandom.current().nextInt(MIN_AMOUNT, MAX_AMOUNT + 1)))
        );
        pool.shutdown();
        try {
            if (pool.awaitTermination(Long.MAX_VALUE, TimeUnit.MILLISECONDS)) {
                log.info("Food delivery is finished");
            } else {
                log.error("The pool is not terminated");
            }
        } catch (InterruptedException e) {
            log.error("Main thread interrupted");
            Thread.currentThread().interrupt();
        }
    }
}

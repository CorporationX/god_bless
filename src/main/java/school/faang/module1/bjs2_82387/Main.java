package school.faang.module1.bjs2_82387;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Slf4j
public class Main {

    private static final int TIMEOUT = 1;
    private static final int POOL_SIZE = Runtime.getRuntime().availableProcessors() * 4;
    public static final ExecutorService executor = Executors.newFixedThreadPool(POOL_SIZE);

    public static void main(String[] args) {
        SquareSumCalculator calculator = new SquareSumCalculator(executor);
        calculator.launch();
        executor.shutdown();
        try {
            if (!executor.awaitTermination(TIMEOUT, TimeUnit.MINUTES)) {
                log.warn("Не все задачи успели выполниться. Принудительное завершение");
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            executor.shutdownNow();
            Thread.currentThread().interrupt();
            log.error("Поток был прерван", e);
        }
    }
}
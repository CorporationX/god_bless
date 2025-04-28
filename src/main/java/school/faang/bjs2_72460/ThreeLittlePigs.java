package school.faang.bjs2_72460;

import lombok.extern.slf4j.Slf4j;
import school.faang.bjs2_72460.thread.Pig1Thread;
import school.faang.bjs2_72460.thread.Pig2Thread;
import school.faang.bjs2_72460.thread.Pig3Thread;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Slf4j
public class ThreeLittlePigs {
    private static final int PIGS_COUNT = 3;
    private static final int TERMINATION_TIMEOUT = 30;
    private static final ExecutorService executorService = Executors.newFixedThreadPool(PIGS_COUNT);

    public static void main(String[] args) {
        List.of(new Pig1Thread(), new Pig2Thread(), new Pig3Thread())
                .forEach(executorService::execute);
        dispose();
        log.info("Game over");
    }

    private static void dispose() {
        log.info("Начинаем очистку Executor Service");
        executorService.shutdown();
        try {
            if (!executorService.awaitTermination(TERMINATION_TIMEOUT, TimeUnit.SECONDS)) {
                log.warn("Не удалось завершить все задачи");
                executorService.shutdownNow();
            }
        } catch (InterruptedException e) {
            log.error("Во время очистки возникло исключение: {}", e.getMessage());
            executorService.shutdownNow();
            throw new IllegalStateException("Во время очистки возникло ислючение", e);
        }
    }
}
package school.faang.sprint3.task_60800;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Slf4j
public class WeasleyFamily {
    private static final String[] CHORES = {"помыть посуду", "подмести пол", "приготовить ужин"};
    private static final ExecutorService EXECUTOR = Executors.newFixedThreadPool(3);
    private static final int WAIT_TIMEOUT_MS = 3000;

    public static void main(String[] args) {
        Arrays.stream(CHORES).forEach(chore -> EXECUTOR.submit(new Chore(chore)));
        EXECUTOR.shutdown();

        try {
            if (EXECUTOR.awaitTermination(1, TimeUnit.SECONDS)) {
                EXECUTOR.shutdownNow();
            }
        } catch (InterruptedException e) {
            EXECUTOR.shutdownNow();
            log.error("Ошибка прерывания", e);
        }

        sleep();
        System.out.printf("%d задачи из %d выполнены", Chore.COUNT.get(), CHORES.length);
    }

    private static void sleep() {
        try {
            Thread.sleep(WAIT_TIMEOUT_MS);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            log.error("Поток прерван", e);
            throw new RuntimeException(e);
        }
    }
}

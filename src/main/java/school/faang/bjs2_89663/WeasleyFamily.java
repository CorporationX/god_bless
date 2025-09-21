package school.faang.bjs2_89663;

import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Slf4j
public record WeasleyFamily(List<String> chores) {
    public static final String[] CHORES = {"помыть посуду", "подмести пол", "приготовить ужин"};
    private static final long TIMEOUT_MINUTES = 1L;

    public void startHomework() {
        ExecutorService executor = Executors.newCachedThreadPool();
        log.info("Семья Уизли начинает уборку!");
        for (String task : chores) {
            Chore chore = new Chore(task);
            executor.execute(chore);
        }
        executor.shutdown();
        try {
            if (!executor.awaitTermination(TIMEOUT_MINUTES, TimeUnit.MINUTES)) {
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            executor.shutdownNow();
            Thread.currentThread().interrupt();
        }
        log.info("Задачи выполнены!");
    }
}
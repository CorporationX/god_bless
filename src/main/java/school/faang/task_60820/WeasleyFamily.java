package school.faang.task_60820;

import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Slf4j
public class WeasleyFamily {
    private static final long TERMINATION_TIMOUT_MILLS = 2_000;

    public static void main(String[] args) throws InterruptedException {
        final ExecutorService taskExecutor = Executors.newCachedThreadPool();
        final List<String> chores = List.of(
                "Помыть посуду",
                "Подмести пол",
                "Приготовить ужин");

        chores.stream()
                .map(Chore::new)
                .forEach(taskExecutor::submit);

        shutdownExecutorGracefully(taskExecutor);
    }

    private static void shutdownExecutorGracefully(ExecutorService executor) {
        log.debug("Инициируется завершение работы Executor...");
        executor.shutdown();
        try {
            if (!executor.awaitTermination(TERMINATION_TIMOUT_MILLS, TimeUnit.MILLISECONDS)) {
                log.warn("Executor не завершился в течение заданного времени. Принудительно завершаю...");
                final List<Runnable> cancelledTasks = executor.shutdownNow();
                log.warn("Принудительно остановлено {} задач", cancelledTasks.size());
            } else {
                log.debug("Executor завершил работу корректно.");
            }
        } catch (InterruptedException e) {
            log.error("Завершение работы Executor прервано. Принудительное завершение...", e);
            executor.shutdownNow();
            Thread.currentThread().interrupt();
        }
    }
}

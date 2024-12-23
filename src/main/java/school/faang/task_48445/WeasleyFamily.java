package school.faang.task_48445;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Slf4j
@AllArgsConstructor
public class WeasleyFamily {
    private List<Chore> chores;

    public void doChores() {
        ExecutorService executor = Executors.newCachedThreadPool();

        for (Chore chore : chores) {
            executor.submit(chore);
        }

        executor.shutdown();
        try {
            log.info("Ожидаем окончания всех задач в течение 5 минут...");
            if (!executor.awaitTermination(5, TimeUnit.MINUTES)) {
                log.info("Задачи не завершились за 5 минут, принудительно останавливаем...");
                executor.shutdownNow();
            } else {
                log.info("Все дела выполнены!");
            }
        } catch (InterruptedException e) {
            executor.shutdownNow();
            log.error("Поток был прерван по время ожидания", e);
        }
    }
}

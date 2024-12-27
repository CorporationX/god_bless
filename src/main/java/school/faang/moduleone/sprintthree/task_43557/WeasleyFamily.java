package school.faang.moduleone.sprintthree.task_43557;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Slf4j
public class WeasleyFamily {
    private final List<String> chores;
    private final int timeout = 1;

    public WeasleyFamily() {
        this.chores = new ArrayList<>();
    }

    public void addChores(String... chores) {
        this.chores.addAll(List.of(chores));
    }

    public void doAllChores() {
        ExecutorService executor = Executors.newCachedThreadPool();
        for (String task : chores) {
            Chore chore = new Chore(task);
            executor.execute(chore);
        }
        executor.shutdown();
        try {
            if (!executor.awaitTermination(timeout, TimeUnit.MINUTES)) {
                log.info("Задачи не завершились за указанный таймаут = {} мин. Завершаем принудительно..", timeout);
                executor.shutdownNow();
            }
            log.info("Все задачи успешно завершены");
        } catch (InterruptedException e) {
            log.error("Главный поток был прерван во время ожидания. Принудительно останавливаем пул.");
            executor.shutdownNow();
        }
    }
}

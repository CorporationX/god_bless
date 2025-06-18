package school.faang.bjs2_81136;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Slf4j
public class WeasleyFamily {
    private static final String[] chores = {"помыть посуду", "подмести пол", "приготовить ужин", "постирать белье"};

    public static void main(String[] args) {
        ExecutorService executor = Executors.newCachedThreadPool();

        for (String chore : chores) {
            executor.submit(new Chore(chore));
        }

        executor.shutdown();
        try {
            if (!executor.awaitTermination(1, TimeUnit.MINUTES)) {
                log.info("Не все задачи завершены в указанный период времени.");
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            log.error("Ошибка при ожидании завершения задач.", e);
        }

    }
}

package school.faang.sprint3.bjs2_60742;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Slf4j
public class WeasleyFamily {
    public static void main(String[] args) {
        Chore[] chores = {new Chore("Помыть посуду"),
                new Chore("Подмести пол"),
                new Chore("Приготовить ужин")
        };

        ExecutorService executors = Executors.newCachedThreadPool();
        for (Chore chore : chores) {
            executors.submit(chore);
        }
        executors.shutdown();
        try {
            if (!executors.awaitTermination(10, TimeUnit.SECONDS)) {
                log.error("Задачи не завершились за 10 секунд, принудительно останавливаем...");
                executors.shutdownNow();
            }
        } catch (InterruptedException e) {
            log.error("Поток, прерванный во время завершения работы: {}", e.getMessage());
            executors.shutdownNow();
            Thread.currentThread().interrupt();
        }
    }

}

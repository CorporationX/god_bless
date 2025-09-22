package school.faang.bjs2_89890;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Slf4j
public class WeasleyFamily {
    public static final int TIMEOUT = 10;

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        Chore[] chores = new Chore[]{
                new Chore("Помыть посуду"),
                new Chore("Подмести пол"),
                new Chore("Приготовить ужин"),
                new Chore("Полить цветы"),
                new Chore("Покормить сову")
        };
        for (Chore chore : chores) {
            executorService.submit(chore);
        }
        executorService.shutdown();
        try {
            if (!executorService.awaitTermination(TIMEOUT, TimeUnit.SECONDS)) {
                log.info("Не все задачи успели завершиться!");
                executorService.shutdownNow();
            }
        } catch (InterruptedException e) {
            log.error(e.getMessage());
            executorService.shutdownNow();
        }
    }
}

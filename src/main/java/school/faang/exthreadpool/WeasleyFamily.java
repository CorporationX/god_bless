package school.faang.exthreadpool;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Slf4j
public class WeasleyFamily {
    private final String[] chores = {"помыть посуду", "подмести пол", "приготовить ужин"};
    ExecutorService executor = Executors.newCachedThreadPool();

    public void createChore() {
        for (String chore : chores) {
            Chore choreOfHouse = new Chore(chore);
            executor.submit(choreOfHouse);
        }
        executor.shutdown();
        try {
            if (!executor.awaitTermination(100, TimeUnit.SECONDS)) {
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            log.error("Поток {} был принудительно прерван", Thread.currentThread().getName());
        }
    }
}
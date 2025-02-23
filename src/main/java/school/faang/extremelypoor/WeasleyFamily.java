package school.faang.extremelypoor;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Slf4j
public class WeasleyFamily {
    private static final String[] chores = {"помыть посуду", "подмести пол", "приготовить ужин"};

    public static void main(String[] args) {
        ExecutorService executor = Executors.newCachedThreadPool();
        for (String task : chores) {
            executor.execute(new Chore(task));
        }
        executor.shutdown();
        try {
            if (!executor.awaitTermination(1, TimeUnit.MINUTES)) {
                log.info("Время ожидания по закрытию выполнения потоков превышено");
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            executor.shutdownNow();
            log.error("Главный поток был прерван во время ожидания, принудительно останавливаем пул", e);
        }
    }
}
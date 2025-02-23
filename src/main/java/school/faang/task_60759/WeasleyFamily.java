package school.faang.task_60759;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class WeasleyFamily {
    private static final String[] CHORES = new String[]
            {"помыть посуду", "подмести пол", "приготовить ужин", "вынести мусор"};

    public void executeChores() {
        ExecutorService executor = Executors.newCachedThreadPool();
        for (String chore : CHORES) {
            executor.execute(new Chore(chore));
        }
        executor.shutdown();
        try {
            if (!executor.awaitTermination(60, TimeUnit.SECONDS)) {
                executor.shutdownNow(); // Принудительное завершение, если не завершились за 60 секунд
            }
        } catch (InterruptedException e) {
            executor.shutdownNow();
            Thread.currentThread().interrupt(); // Восстанавливаем флаг
        }
    }
}

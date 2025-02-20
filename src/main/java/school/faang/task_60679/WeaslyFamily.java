package school.faang.task_60679;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class WeaslyFamily {
    private static final String[] CHORES = new String[]{"помыть посуду", "подмести пол", "приготовить ужин"};
    private static final int THREAD_TIMEOUT = 5;

    public static void main(String[] args) {
        ExecutorService executor = Executors.newCachedThreadPool();
        for (int i = 0; i < CHORES.length; i++) {
            executor.execute(new Chore(CHORES[i]));
        }
        executor.shutdown();
        try {
            if (!executor.awaitTermination(THREAD_TIMEOUT, TimeUnit.MINUTES)) {
                System.out.println("Задачи не завершились за 5 минут, принудительно останавливаем...");
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            executor.shutdownNow();
        }
    }
}

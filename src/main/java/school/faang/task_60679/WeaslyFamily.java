package school.faang.task_60679;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class WeaslyFamily {
    public static void main(String[] args) {
        String[] chores = new String[]{"помыть посуду", "подмести пол", "приготовить ужин"};
        ExecutorService executor = Executors.newCachedThreadPool();
        for (int i = 0; i < chores.length; i++) {
            executor.execute(new Chore(chores[i]));
        }
        executor.shutdown();
        try {
            if (!executor.awaitTermination(5, TimeUnit.MINUTES)) {
                System.out.println("Задачи не завершились за 5 минут, принудительно останавливаем...");
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            executor.shutdownNow();
        }
    }
}

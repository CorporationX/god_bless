package school.faang.sprint_3.task_48514;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class WeasleyFamily {
    private static final String[] chores = new String[] {
            "Помыть посуду",
            "Подмести пол",
            "Приготовить ужин",
            "Вытереть пыль"
    };

    public static void splitChores() {
        ExecutorService executor = Executors.newCachedThreadPool();

        for (String chore : chores) {
            Chore choreRunnable = new Chore(chore);
            executor.execute(choreRunnable);
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

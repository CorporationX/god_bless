package school.faang.sprint_3.task_43558;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class BigBangTheory {
    private static final int POOL_SIZE = 4;
    private static final int TIMEOUT = 5;

    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(POOL_SIZE);

        List<Task> tasks = new ArrayList<>(
                List.of(new Task("Шелдон", "Подготовка теории"),
                        new Task("Леонард", "Моделирование эксперимента"),
                        new Task("Говард", "Разработка инструментов"),
                        new Task("Раджеш", "Анализ данных")));

        for (Task task : tasks) {
            executor.execute(task);
        }

        executor.shutdown();

        try {
            if (!executor.awaitTermination(TIMEOUT, TimeUnit.MINUTES)) {
                System.out.println("Задачи не завершились за " + TIMEOUT + " минут, принудительно останавливаем...");
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            executor.shutdownNow();
        }
    }
}

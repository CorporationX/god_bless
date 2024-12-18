package school.faang.thebigbangtheory;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class BigBangTheory {
    public static final int THREAD_POOL_SIZE = 4;
    public static final int AWAIT_TIME = 10;

    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(THREAD_POOL_SIZE);
        List<Task> tasks = List.of(
                new Task("Шелдон", "Подготовка теории"),
                new Task("Леонард", "Моделирование эксперимента"),
                new Task("Говард", "Разработка инструментов"),
                new Task("Раджеш", "Анализ данных")
        );
        for (Task task : tasks) {
            executor.submit(task);
        }

        executor.shutdown();

        try {
            if (!executor.awaitTermination(AWAIT_TIME, TimeUnit.SECONDS)) {
                System.out.println("Не все задачи завершены в указанный период времени.");
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            executor.shutdownNow();
        }
    }
}

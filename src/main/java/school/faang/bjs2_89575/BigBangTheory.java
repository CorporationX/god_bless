package school.faang.bjs2_89575;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class BigBangTheory {
    public static final int THREAD_POOL_SIZE = 4;

    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(THREAD_POOL_SIZE);

        List<Task> tasks = List.of(
                new Task("Шелдон", "подготовка теории"),
                new Task("Леонард", "моделирование эксперимента"),
                new Task("Говард", "разработка инструментов"),
                new Task("Раджеш", "анализ данных")
        );

        for (Task task : tasks) {
            executor.submit(task);
        }

        executor.shutdown();

        try {
            if (!executor.awaitTermination(30, TimeUnit.SECONDS)) {
                System.out.println("Выполнение задач затянулось, завершаем.");
                executor.shutdownNow();
            }
            System.out.println("Все задачи выполнены.");
        } catch (InterruptedException e) {
            System.out.println("Выполнение задач прервано.");
            executor.shutdownNow();
            throw new RuntimeException(e);
        }
    }
}

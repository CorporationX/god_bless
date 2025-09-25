package school.faang.bjs2_89575;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

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
    }
}

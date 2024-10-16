package the_big_bang_theory;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class BigBangTheory {
    private static final int COUNT_TASKS = 4;
    private static final ExecutorService EXECUTOR_SERVICE = Executors.newFixedThreadPool(COUNT_TASKS);

    public static void main(String[] args) {
        List<Task> tasks = List.of(
                new Task("Шелдон", "Подготовка теории"),
                new Task("Леонард", "Моделирование эксперимента"),
                new Task("Говард", "Разработка инструментов"),
                new Task("Раджеш", "Анализ данных")
        );

        tasks.forEach(EXECUTOR_SERVICE::submit);

        EXECUTOR_SERVICE.shutdown();
    }
}

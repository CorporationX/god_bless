package school.faang.spring3.task_48302;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class BigBangTheory {
    private static final int COUNT_THREAD = 4;

    public static void main(String[] args) {
        List<Task> tasks = List.of(
                new Task("Шелдон", "подготовка теории"),
                new Task("Леонард", "моделирование эксперимента"),
                new Task("Говард", "разработка инструментов"),
                new Task("Раджеш", "анализ данных")
        );

        ExecutorService service = Executors.newFixedThreadPool(COUNT_THREAD);
        for (int i = 0; i < tasks.size(); i++) {
            service.execute(tasks.get(i));
        }
        service.shutdown();
    }
}

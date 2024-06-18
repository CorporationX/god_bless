package faang.school.godbless.multithreading_parallelism.task_4;

import java.util.List;

public class TaskProvider {
    public static List<Task> getTasks() {
        return List.of(
                new Task("Шелдон", "подготовка теории"),
                new Task("Леонард", "моделирование эксперимента"),
                new Task("Говард", "разработка инструментов"),
                new Task("Раджеш", "анализ данных")
        );
    }
}

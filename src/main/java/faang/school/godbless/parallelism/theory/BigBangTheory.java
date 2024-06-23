package faang.school.godbless.parallelism.theory;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class BigBangTheory {
    public static void main(String[] args) {
        Task task1 = new Task("Шелдон", "подготовка теории");
        Task task2 = new Task("Леонард", "моделирование эксперимента");
        Task task3 = new Task("Говард", "разработка инструментов");
        Task task4 = new Task("Раджеш", "анализ данных");
        List<Task> taskList = List.of(task1, task2, task3, task4);
        DistributeTasks(taskList);
    }

    public static void DistributeTasks(List<Task> taskList) {
        ExecutorService service = Executors.newFixedThreadPool(4);
        taskList.forEach(service::submit);
        service.shutdown();
    }
}

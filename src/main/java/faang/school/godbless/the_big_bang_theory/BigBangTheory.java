package faang.school.godbless.the_big_bang_theory;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class BigBangTheory {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(4);

        Task task1 = new Task("Шелдон", "подготовка теории");
        Task task2 = new Task("Леонард", "моделирование эксперимента");
        Task task3 = new Task("Говард", "разработка инструментов");
        Task task4 = new Task("Раджеш ", "анализ данных");

        List<Task> tasks = Arrays.asList(task1, task2, task3, task4);

        for (Task task : tasks) {
            executorService.execute(task);
        }
        executorService.shutdown();
    }
}

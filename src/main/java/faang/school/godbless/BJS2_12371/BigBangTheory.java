package faang.school.godbless.BJS2_12371;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class BigBangTheory {
    public static void main(String[] args) {

        ExecutorService executorService = Executors.newFixedThreadPool(4);

        List<Task> tasks = new ArrayList<>();

        tasks.add(new Task("Шелдон", "подготовка теории"));
        tasks.add(new Task("Леонард", "моделирование эксперимента"));
        tasks.add(new Task("Говард", "разработка инструментов"));
        tasks.add(new Task("Раджеш", "анализ данных"));

        for (var task: tasks) {
            executorService.submit(task);
        }

        executorService.shutdown();
    }
}

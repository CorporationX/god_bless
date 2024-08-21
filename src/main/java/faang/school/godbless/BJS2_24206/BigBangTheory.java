package faang.school.godbless.BJS2_24206;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class BigBangTheory {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(4);

        List<Task> tasks = new ArrayList<>(List.of(
                new Task("Шелдон", "Подготовка теории"),
                new Task("Леонард", "Моделирование эксперимента"),
                new Task("Говард", "Разработка инструментов"),
                new Task("Раджеш", "Анализ данных")
        ));

        for (Task task : tasks) {
            executorService.execute(task);
        }

        executorService.shutdown();
    }
}

package faang.school.godbless.javamultithreading.task4;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class BigBangTheory {
    public static void main(String[] args) {
        List<Task> tasks = List.of(new Task("Шелдон", "Подготовка теории"),
                new Task("Леонард", "Моделирование эксперимента"),
                new Task("Говард", "Разработка инструментов"),
                new Task("Раджеш", "Анализ данных"));

        ExecutorService executorService = Executors.newFixedThreadPool(4);
        tasks.forEach(executorService::execute);
        executorService.shutdown();
    }
}

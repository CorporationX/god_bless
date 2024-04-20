package faang.school.godbless.module.third.parallelism.bang;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class BigBangTheory {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(4);
        List<Task> tasks = List.of(
            new Task("Шелдон", "подготовка теории"),
            new Task("Леонард", "моделирование эксперимента"),
            new Task("Говард", "разработка инструментов"),
            new Task("Раджеш", "анализ данных")
        );
        for (Task task : tasks) {
            executorService.execute(task);
        }
        executorService.shutdown();
        try {
            executorService.awaitTermination(5, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}

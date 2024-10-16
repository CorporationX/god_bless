package school.faang.bigbangtheory;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class BigBangTheory {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(4);
        List<Task> tasks = Arrays.asList(
                new Task("Шелдон", "подготовка теории"),
                new Task("Леонард", "моделирование эксперимента"),
                new Task("Говард", "разработка инструментов"),
                new Task("Раджеш", "анализ данных"));

        for (Task task : tasks) {
            executorService.awaitTermination(1, TimeUnit.SECONDS);
            executorService.execute(task);
        }

        executorService.shutdown();
    }
}

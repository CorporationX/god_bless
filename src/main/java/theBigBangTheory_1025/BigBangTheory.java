package theBigBangTheory_1025;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class BigBangTheory {
    public static void main(String[] args) throws InterruptedException {

        ExecutorService executorService = Executors.newFixedThreadPool(4);

        List<Task> tasks = List.of(new Task("Шелдон", "подготовка теории"),
                new Task("Леонард", "моделирование эксперимента"),
                new Task("Говард", "разработка инструментов"),
                new Task("Раджеш", "анализ данных"));

        for (Task task : tasks) {
            Thread.currentThread().setName("поток для " + task.getName());
            executorService.execute(task);
        }
        executorService.shutdown();

        if (executorService.awaitTermination(6, TimeUnit.SECONDS)) System.out.println("Все задачи были выполнены");
    }
}
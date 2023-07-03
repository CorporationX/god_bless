package Multithreading.bc2233;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class BigBangTheory {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(4);
        List<Task> tasks = new ArrayList<>();
        Collections.addAll(tasks, new Task("Шелдон", "подготовка теории"),
                new Task("Леонард", "моделирование эксперимента"),
                new Task("Говард", "разработка инструментов"),
                new Task("Раджеш", "анализ данных"));
        for (Task task : tasks) {
            executorService.execute(task);
        }
        executorService.shutdown();

        boolean isFinished = executorService.awaitTermination(5, TimeUnit.SECONDS);

        if (isFinished) {
            System.out.println("All tasks completed");
        }

    }
}

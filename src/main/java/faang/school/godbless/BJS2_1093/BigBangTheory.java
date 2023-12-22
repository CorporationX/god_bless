package faang.school.godbless.BJS2_1093;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class BigBangTheory {
    public static void main(String[] args) {
        Task task1 = new Task("Шелдон", "подготовка теории");
        Task task2 = new Task("Леонард", "моделирование эксперимента");
        Task task3 = new Task("Говард", "разработка инструментов");
        Task task4 = new Task("Раджеш", "анализ данных");

        ExecutorService executor = Executors.newFixedThreadPool(4);

        executor.submit(task1);
        executor.submit(task2);
        executor.submit(task3);
        executor.submit(task4);

        executor.shutdown();

        try {
            executor.awaitTermination(Long.MAX_VALUE, TimeUnit.NANOSECONDS);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("All tasks completed!");
    }
}
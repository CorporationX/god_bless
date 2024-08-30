package faang.school.godbless.multithreading.parallelism.bigbang;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class BigBangTheory {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(4);

        Task task1 = new Task("Шелдон", "подготовка теории");
        Task task2 = new Task("Леонард", "моделирование эксперимента");
        Task task3 = new Task("Говард", "разработка инструментов");
        Task task4 = new Task("Раджеш", "анализ данных");

        executor.execute(task1);
        executor.execute(task2);
        executor.execute(task3);
        executor.execute(task4);

        executor.shutdown();

        while (!executor.isTerminated()) {
            try {
                System.out.println("Executor is not terminated, wait for it to terminate 1 second");
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        System.out.println("Executor is terminated");
    }
}

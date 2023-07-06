package faang.school.godbless.Multithreading.ParallelismAndThread.task06_TheBigBangTheory;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class BigBangTheory {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(4);
        Task task1 = new Task("Шелдон", "подготовка теории");
        Task task2 = new Task("Леонард", "моделирование эксперимента");
        Task task3 = new Task("Говард", "разработка инструментов");
        Task task4 = new Task("Раджеш", "анализ данных");

        executorService.execute(task1);
        executorService.execute(task2);
        executorService.execute(task3);
        executorService.execute(task4);

        executorService.shutdown();
        try {
            if (executorService.awaitTermination(15, TimeUnit.SECONDS)) {
                System.out.println("Все задачи выполнены");
            } else {
                System.out.println("Ошибка");
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}

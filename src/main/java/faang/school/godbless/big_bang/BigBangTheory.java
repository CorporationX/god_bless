package faang.school.godbless.big_bang;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class BigBangTheory {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService executor = Executors.newFixedThreadPool(4);
        Task task1 = new Task("Шелдон", "подготовка теории");
        Task task2 = new Task("Леонард", "моделирование эксперимента");
        Task task3 = new Task("Говард", "разработка инструментов");
        Task task4 = new Task("Раджеш", "анализ данных");
        executor.execute(task1);
        executor.execute(task2);
        executor.execute(task3);
        executor.execute(task4);
        executor.awaitTermination(5, TimeUnit.SECONDS);
        System.out.println("Все задачи выполнены!");
        executor.shutdown();
    }
}

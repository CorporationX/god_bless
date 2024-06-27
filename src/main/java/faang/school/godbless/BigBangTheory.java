package faang.school.godbless;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class BigBangTheory {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(4);
        Task taskSheldon = new Task("Шелдон", "подготовка теории");
        Task taskLeonard = new Task("Леонард", "моделирование эксперимента");
        Task taskHovard = new Task("Говард", "разработка инструментов");
        Task taskRadjesh = new Task("Раджеш", "анализ данных");
        executor.execute(taskSheldon);
        executor.execute(taskLeonard);
        executor.execute(taskHovard);
        executor.execute(taskRadjesh);
        executor.shutdown();
        try {
            executor.awaitTermination(Long.MAX_VALUE, TimeUnit.NANOSECONDS);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Все задачи выполнены");
    }
}

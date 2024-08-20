package faang.school.godbless.BJS2_24145;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class BigBangTheory {
    public static void main(String[] args) {
        Task task1 = new Task("Шелдон ", "подготовка теории");
        Task task2 = new Task("Леонард  ", "моделирование эксперимента");
        Task task3 = new Task("Говард  ", "разработка инструментов");
        Task task4 = new Task("Раджеш  ", "анализ данных");

        ExecutorService executor = Executors.newFixedThreadPool(4);
        executor.execute(task1);
        executor.execute(task2);
        executor.execute(task3);
        executor.execute(task4);
        executor.shutdown();

    }
}

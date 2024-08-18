package faang.school.godbless.BJS2_24004;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class BigBangTheory {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(4);
        List<Task> tasks = List.of(
                new Task("Sheldon", "Подготовка теории"),
                new Task("Leonard", "Моделирование эксперимента"),
                new Task("Howard", "Разработка инструментов"),
                new Task("Rajesh", "Анализ данных")
        );
        tasks.forEach(executor::execute);
        executor.shutdown();

        try {
            executor.awaitTermination(5, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("Все задачи выполнены!");
    }
}

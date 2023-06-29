package faang.school.godbless.multithreading.big_bang;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class BigBangTheory {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(4);
        List<Runnable> tasks = List.of(
                new Task("Шелдон", "подготовка теории"),
                new Task("Леонард", "моделирование эксперимента"),
                new Task("Говард", "разработка инструментов"),
                new Task("Раджеш", "анализ данных")
        );

        tasks.forEach(executorService::execute);
        executorService.shutdown();

        boolean isDone = false;

        try {
            isDone = executorService.awaitTermination(1, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            System.out.println("Выполнение задания было прервано");
        }

        if (isDone)
            System.out.println("done");
    }
}

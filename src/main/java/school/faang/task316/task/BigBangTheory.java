package school.faang.task316.task;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;

public class BigBangTheory {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService executor = Executors.newFixedThreadPool(4);

        Task firstTask = new Task("Шелдон", "подготовка теории");
        Task secondTask = new Task("Леонард", "моделирование эксперимента");
        Task thirdTask = new Task("Говард", "разработка инструментов");
        Task fourthTask = new Task("Раджеш", "анализ данных");
        Stream.of(firstTask, secondTask, thirdTask, fourthTask).map(executor::submit).toList();

        executor.shutdown();

        try {
            if (!executor.awaitTermination(1, TimeUnit.MINUTES)) {
                System.out.println("Не все задачи завершены.");
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            throw new InterruptedException();
        }

    }
}

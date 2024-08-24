package thread.four;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;

public class BigBangTheory {

    public static void main(String[] args) {

        int threadCount = 4;
        ExecutorService executor = Executors.newFixedThreadPool(threadCount);
        List<Task> tasks = Stream.of(new Task("Шелдон", "подготовка теории"),
                        new Task("Леонард", "моделирование эксперимента"),
                        new Task("Говард ", "разработка инструментов"),
                        new Task("Раджеш ", "анализ данных"))
                .toList();

        tasks.forEach(executor::execute);
        executor.shutdown();

        try {
            if (executor.awaitTermination(5, TimeUnit.MINUTES)) {
                System.out.println("Все задания выполнены.");
            } else {
                System.out.println("Не все задания выполнены в отведенное время.");
            }
        } catch (InterruptedException e) {
            executor.shutdownNow();
            System.out.println("Выполнение заданий было прервано.");
        }
    }
}

package bigBang;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class BigBangTheory {
    public static final int THREADAMOUNT = 4;

    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(THREADAMOUNT);
        Task task1 = new Task("Шелдон", "подготовка теории");
        Task task2 = new Task("Леонард", "моделирование эксперимента");
        Task task3 = new Task("Говард", "разработка инструментов");
        Task task4 = new Task("Раджеш", "анализ данных");
        List<Task> tasks = List.of(task1, task2, task3, task4);
        tasks.forEach(task -> executorService.submit(task));
        executorService.shutdown();
        if (!executorService.awaitTermination(Long.MAX_VALUE, TimeUnit.NANOSECONDS)) {
            executorService.shutdownNow();
        }
        System.out.println("Задания все выполнены");

    }
}

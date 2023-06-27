package Sprint_4_Task6;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class BigBangTheory {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(4);
        Task task1 = new Task("Шелдон","подготовка теории");
        Task task2 = new Task("Леонард","моделирование эксперимента");
        Task task3 = new Task("Говард","разработка инструментов");
        Task task4 = new Task("Раджеш","анализ данных");

        executorService.submit(task1);
        executorService.submit(task2);
        executorService.submit(task3);
        executorService.submit(task4);

        executorService.shutdown();
        while (!executorService.isTerminated()){
            executorService.awaitTermination(1, TimeUnit.MILLISECONDS);
        }
        System.out.println("Конец задачи");
    }
}

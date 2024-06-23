package faang.school.godbless.multithreading.parallelism.theBigBangTheory;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class BigBangTheory {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(4);

        Task sheldonTask = new Task("Шелдон", "подготовка теории");
        Task leonardTask = new Task("Леонард", "моделирование эксперимента");
        Task howardTask = new Task("Говард","разработка инструментов");
        Task rajeshTask = new Task("Раджеш", "анализ данных");

        executor.execute(sheldonTask);
        executor.execute(leonardTask);
        executor.execute(howardTask);
        executor.execute(rajeshTask);

        executor.shutdown();

        try {
            if (executor.awaitTermination(1, TimeUnit.MINUTES)) {
                System.out.println("All tasks are completed!");
            }
        } catch (InterruptedException e) {
            System.out.println("Waiting was interrupted");
        }
    }
}

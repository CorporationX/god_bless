package faang.school.godbless.alexbulgakoff.multithreading.parallelism.thebigbangtheory;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @author Alexander Bulgakov
 */

public class BigBangTheory {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(4);

        Task bySheldon = new Task("Теория", "подготовка теории");
        Task byLeonard = new Task("Эксперимент", "моделирование эксперимента");
        Task byGovard = new Task("Инструменты", "разработка инструментов");
        Task byRadjesh = new Task("Данные", "анализ данных");

        executorService.execute(bySheldon);
        executorService.execute(byLeonard);
        executorService.execute(byGovard);
        executorService.execute(byRadjesh);

        executorService.shutdown();
        try {
            executorService.awaitTermination(15, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("Все задания выполнены");
    }
}

package school.faang.bjs2_89908;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class BigBangTheory {
    @SuppressWarnings("checkstyle:ModifierOrder")
    private final static int THREAD_AMOUNT = 4;

    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(THREAD_AMOUNT);
        Task task1 = new Task("Эта задача", "Доделать эту задачу.");
        Task task2 = new Task("Правка предыдущих задач", "Исправить задачи, не прошедшие Review");
        Task task3 = new Task("Новые задачи", "Решить еще 2 задачи");
        Task task4 = new Task("StandUp", "Созвониться с командой и тим-лидом.");
        executor.execute(task1);
        executor.execute(task2);
        executor.execute(task3);
        executor.execute(task4);
        executor.shutdown();
        try {
            if (!executor.awaitTermination(2, TimeUnit.MINUTES)) {
                System.out.println("Поток main устал ждать, какая-то задача заснула навечно )");
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println("Поток main не смог дождаться, его прервали.");
        }
    }
}

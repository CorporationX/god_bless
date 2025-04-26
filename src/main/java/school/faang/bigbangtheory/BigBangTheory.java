package school.faang.bigbangtheory;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class BigBangTheory {
    private static final int THREAD_POOL_SIZE = 4;
    private static final int AWAITING_SECONDS = 10;

    public static void softShutdown(ExecutorService executor) {
        executor.shutdown();

        try {
            if (!executor.awaitTermination(AWAITING_SECONDS, TimeUnit.SECONDS)) {
                System.out.println("Execution is not terminated in time. Forced shutdown!");
                executor.shutdownNow();
            } else {
                System.out.println("Execution terminated successfully!");
            }
        } catch (InterruptedException e) {
            System.out.println("Main thread was interrupted. Forcing shutdown...");
            executor.shutdownNow();
            Thread.currentThread().interrupt();
        }
    }


    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(THREAD_POOL_SIZE);

        Task sheldon = new Task("Шелдон", "Подготовка теории");
        Task leonard = new Task("Леонард", "Моделирование эксперимента");
        Task howard = new Task("Говард", "Разработка инструментов");
        Task rajesh = new Task("Раджеш", "Анализ данных");

        executor.submit(sheldon);
        executor.submit(leonard);
        executor.submit(howard);
        executor.submit(rajesh);

        softShutdown(executor);
    }
}
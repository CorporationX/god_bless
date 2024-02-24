package miceAreVeryNice;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Main {
    private static final int NUM_THREADS = 5;

    public static void main(String[] args) {
        House house = new House();
        house.initialize();

        System.out.println("Информация о доме до сбора еды: ");
        System.out.println(house);

        ScheduledExecutorService executor = Executors.newScheduledThreadPool(NUM_THREADS);

        for (int i = 0; i < NUM_THREADS; i++) {
            final int threadNumber = i + 1;
            executor.schedule(() -> {
                System.out.println("Thread " + threadNumber + " collecting food...");
                house.collectFood();
            }, i * 5, TimeUnit.SECONDS);
        }

        executor.shutdown();

        try {
            if (!executor.awaitTermination(1, TimeUnit.HOURS)) {
                System.out.println("Прошло более часа, но не все задачи завершились.");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("\nИнформация о доме после сбора еды:");
        System.out.println(house);
    }
}

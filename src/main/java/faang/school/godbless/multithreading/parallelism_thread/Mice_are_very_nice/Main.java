package faang.school.godbless.multithreading.parallelism_thread.Mice_are_very_nice;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {
        House house = new House();
        house.initialize();

        ScheduledExecutorService executor = Executors.newScheduledThreadPool(5);

        for (int i = 0; i < 5; i++) {
            executor.schedule(() -> house.collectFood(), i * 5, TimeUnit.SECONDS);
        }
        executor.shutdown();
        try {
            executor.awaitTermination(10, TimeUnit.MINUTES);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Вся еда собрана!");
        System.out.println(house.getFoods());

    }
}

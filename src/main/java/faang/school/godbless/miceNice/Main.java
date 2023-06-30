package faang.school.godbless.miceNice;

import java.util.concurrent.*;

public class Main {
    public static void main(String[] args) {
        House house = new House();
        house.initialize();

        ScheduledExecutorService executor = Executors.newScheduledThreadPool(5);

        for (int i = 0; i < 5; i++) {
            executor.schedule(() -> house.collectFood(), 30 * i, TimeUnit.SECONDS);
        }

        try {
            executor.shutdown();
            executor.awaitTermination(1, TimeUnit.MINUTES);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}

package school.faang.bjs249007;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class BigBangTheory {

    private static final int POOL_SIZE = 4;

    public static void main(String[] args) {
        ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(POOL_SIZE);
        Task sheldonTask = new Task("Sheldon", "prepare theorems");
        Task leonardTask = new Task("Leonard", "modelling experiments");
        Task howardTask = new Task("Howard", "developing tools");
        Task rajeshTask = new Task("Rajesh", "data analysis");

        scheduler.schedule(sheldonTask, 0, TimeUnit.SECONDS);
        scheduler.schedule(leonardTask, 5, TimeUnit.SECONDS);
        scheduler.schedule(howardTask, 10, TimeUnit.SECONDS);
        scheduler.schedule(rajeshTask, 15, TimeUnit.SECONDS);

        scheduler.shutdown();
    }

}

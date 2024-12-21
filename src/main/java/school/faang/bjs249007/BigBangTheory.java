package school.faang.bjs249007;

import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.atomic.AtomicInteger;

import static java.util.concurrent.TimeUnit.SECONDS;

public class BigBangTheory {

    private static final int POOL_SIZE = 4;

    public static void main(String[] args) {
        ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(POOL_SIZE);
        List<Task> list = List.of(
                new Task("Sheldon", "prepare theorems"),
                new Task("Leonard", "modelling experiments"),
                new Task("Howard", "developing tools"),
                new Task("Rajesh", "data analysis"));
        AtomicInteger timeInterval = new AtomicInteger(5);
        list.forEach(task -> {
            scheduler.schedule(task, timeInterval.getAndAdd(5), SECONDS);
        });
        scheduler.shutdown();
    }

}

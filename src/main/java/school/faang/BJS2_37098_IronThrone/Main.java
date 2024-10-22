package school.faang.BJS2_37098_IronThrone;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Slf4j
public class Main {
    private static final int THREAD_POOL_SIZE = 3;
    private static final int PAUSE_TIME = 1_000;

    public static void main(String[] args) {
        User ivan = new User("Ivan");
        User sasha = new User("Sasha");
        User petr = new User("Petr");
        User fedor = new User("Fedor");

        List<String> availableRoles = new ArrayList<>(List.of("lord", "mage", "knight"));
        House lonnister = new House("Lonnister", availableRoles);

        ExecutorService executor = Executors.newFixedThreadPool(THREAD_POOL_SIZE);
        executor.submit(() -> ivan.joinHouse(lonnister));
        executor.submit(() -> sasha.joinHouse(lonnister));
        executor.submit(() -> petr.joinHouse(lonnister));
        executor.submit(() -> fedor.joinHouse(lonnister));
        try {
            Thread.sleep(PAUSE_TIME);
        } catch (InterruptedException e) {
            log.error("Main thread was interrupted when putted on pause (sleep).", e);
        }
        executor.submit(ivan::leaveHouse);

        executor.shutdown();
        try {
            if (!executor.awaitTermination(10, TimeUnit.SECONDS)) {
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            executor.shutdownNow();
        }
    }
}

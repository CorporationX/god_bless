package school.faang.sync.GoT;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

@Slf4j
public class Main {

    private static final int MIN_SLEEP_MS = 1000;
    private static final int MAX_SLEEP_MS = 2000;
    private static final int TERMINATION_MN = 1;

    public static void main(String[] args) {
        House firstHouse = new House(HouseRoles.values());

        ExecutorService userPool = Executors.newFixedThreadPool(10);

        for (int i = 0; i < 20; i++) {
            String userName = String.format("User №%d", i);
            HouseRoles randomHouse = HouseRoles.getRandomHouseRole();
            User newUser = new User(userName, randomHouse, firstHouse);
            userPool.submit(() -> {
                try {
                    newUser.joinHouse();
                    TimeUnit.MILLISECONDS.sleep(ThreadLocalRandom.current().nextInt(MIN_SLEEP_MS, MAX_SLEEP_MS));
                    newUser.leaveHouse();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            });
        }
        userPool.shutdown();
        try {
            if (!userPool.awaitTermination(TERMINATION_MN, TimeUnit.MINUTES)) {
                userPool.shutdownNow();
                log.warn("Threads have not finished their work, forcing shut down");
            }
        } catch (InterruptedException e) {
            userPool.shutdownNow();
        }
    }

}

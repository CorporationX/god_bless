package school.faang.bjs2_73288;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Slf4j
public class Main {
    public static final int TIME_SPENDING_IN_HOUSE = 5000;
    public static final int AWAITING_TIME = 2;

    public static void main(String[] args) {
        List<User> users = Arrays.asList(new User("Alice"), new User("Annie"), new User("Mert"),
                new User("Asmik"), new User("Liza"));
        House house = new House(new HashSet<>(Arrays.stream(Role.values()).toList()));
        ExecutorService executorService = Executors.newFixedThreadPool(users.size());
        users.forEach(user -> {
            executorService.execute(() -> {
                user.joinHouse(house);
                try {
                    Thread.sleep(TIME_SPENDING_IN_HOUSE);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    throw new IllegalStateException("The thread was interrupted while user where spending time in " +
                            "the house", e);
                }
                user.leaveHouse(house);
            });
        });
        executorService.shutdown();
        try {
            if (!executorService.awaitTermination(AWAITING_TIME, TimeUnit.MINUTES)) {
                executorService.shutdownNow();
                log.info("Timeout: all roles were not released within the allotted time");
            }
        } catch (InterruptedException e) {
            executorService.shutdownNow();
            Thread.currentThread().interrupt();
            throw new IllegalStateException("The thread was interrupted while waiting for completion of the release " +
                    "of all roles", e);
        }
    }
}

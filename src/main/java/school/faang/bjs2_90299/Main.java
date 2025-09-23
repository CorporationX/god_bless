package school.faang.bjs2_90299;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Slf4j
public class Main {
    private static final int POOL_SIZE_THREAD = 10;
    private static final int MIN_TIME_WORK = 2000;
    private static final int MAX_TIME_WORK = 30000;
    private static final int TIME_WAITING = 5;

    public static void main(String[] args) {
        House house = new House();
        house.addRole(Role.BUTLER);
        house.addRole(Role.COOK);
        house.addRole(Role.CLEANER);
        house.addRole(Role.SECURITY_GUARD);
        house.addRole(Role.GARDENER);

        List<User> userList = Arrays.asList(
                new User("andrew"),
                new User("Stark"),
                new User("Misha"),
                new User("iLya"),
                new User("Oleg"),
                new User("Dima"),
                new User("Grisha"),
                new User("Pavel"),
                new User("Dima")
        );

        ExecutorService executor = Executors.newFixedThreadPool(POOL_SIZE_THREAD);

        createThread(executor, userList, house);

        executorShutdown(executor);
    }

    public static void createThread(ExecutorService executor, List<User> userList, House house) {
        Random random = new Random();
        userList.stream().forEach(user -> {
            executor.submit(() -> {
                user.joinHouse(house);
                try {
                    Thread.sleep(random.nextInt(MIN_TIME_WORK, MAX_TIME_WORK));
                } catch (InterruptedException e) {
                    log.error("Error in stream:", e.getMessage());
                    throw new RuntimeException(e);
                }
                user.leaveHouse(house);
            });
        });
    }

    public static void executorShutdown(ExecutorService executor) {
        executor.shutdown();
        try {
            if (!executor.awaitTermination(TIME_WAITING, TimeUnit.MINUTES)) {
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            log.error("Error in stream:", e.getMessage());
            executor.shutdownNow();
            throw new RuntimeException(e);
        }
    }
}

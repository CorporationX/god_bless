package school.faang.godbless.bjs2_37083;

import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Slf4j
public class Main {
    private static final int NUMBER_OF_THREADS = 6;
    private static final int SLEEP_MILLIS = 1000;

    public static void main(String[] args) throws InterruptedException {
        House house = new House(List.of(
                "Role1", "Role2", "Role3"
        ));
        List<User> userList = List.of(
                new User("User1", house),
                new User("User2", house),
                new User("User3", house),
                new User("User4", house),
                new User("User5", house),
                new User("User6", house)
        );
        ExecutorService pool = Executors.newFixedThreadPool(NUMBER_OF_THREADS);
        userList.forEach(user ->
                pool.submit(() -> {
                    try {
                        user.joinHouse();
                        Thread.sleep(SLEEP_MILLIS);
                        user.leaveHouse();
                    } catch (InterruptedException e) {
                        log.warn("Interrupting thread while user is in the house");
                    }
                })
        );
        pool.shutdown();
        if (pool.awaitTermination(Long.MAX_VALUE, TimeUnit.MILLISECONDS)) {
            log.info("Pool is terminated");
        } else {
            log.error("Failed to terminate the pool");
        }
    }
}

package school.faang.task_48888;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class MainApp {
    private static final Logger log = LoggerFactory.getLogger(MainApp.class);

    public static void main(String[] args) {
        House starkHouse = new House("Stark",
                Arrays.asList(UserRole.ARCHER, UserRole.MAGE, UserRole.LORD, UserRole.WARRIOR));
        ExecutorService executor = Executors.newFixedThreadPool(10);

        User user1 = new User("Jon");
        executor.execute(() -> user1.joinHouse(starkHouse, UserRole.LORD));
        User user2 = new User("Arya");
        executor.execute(() -> user2.joinHouse(starkHouse, UserRole.WARRIOR));
        User user3 = new User("Bran");
        executor.execute(() -> user3.joinHouse(starkHouse, UserRole.MAGE));
        User user4 = new User("Robb");
        executor.execute(() -> user4.joinHouse(starkHouse, UserRole.LORD));

        executor.execute(() -> {
            try {
                Thread.sleep(5000);
                user1.leaveHouse();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });

        executor.shutdown();
        try {
            if (executor.awaitTermination(5000, TimeUnit.MILLISECONDS)) {
                log.info("All users have been joined");
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}

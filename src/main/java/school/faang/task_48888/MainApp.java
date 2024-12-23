package school.faang.task_48888;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class MainApp {
    private static final Logger log = LoggerFactory.getLogger(MainApp.class);

    public static void main(String[] args) {
        House starkHouse = new House("Stark",
                Arrays.asList(UserRole.ARCHER, UserRole.MAGE, UserRole.LORD, UserRole.WARRIOR));

        ExecutorService executor = Executors.newFixedThreadPool(10);
        List<User> users = Arrays.asList(
                new User("Jon", UserRole.LORD),
                new User("Arya", UserRole.WARRIOR),
                new User("Bran", UserRole.MAGE),
                new User("Robb", UserRole.LORD)
        );

        users.forEach(user -> executor.execute(() -> user.joinHouse(starkHouse, user.getUserRole())));
        executor.execute(() -> {
            try {
                Thread.sleep(5000);
                users.get(0).leaveHouse();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });

        executor.shutdown();
        try {
            if (executor.awaitTermination(5000, TimeUnit.MILLISECONDS)) {
                log.info("All users have been joined or tasks are completed.");
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}

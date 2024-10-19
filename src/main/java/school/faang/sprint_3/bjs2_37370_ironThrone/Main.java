package school.faang.sprint_3.bjs2_37370_ironThrone;

import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Slf4j
public class Main {
    public static final int THREADS_COUNT = 5;

    public static void main(String[] args) {
        Set<String> roles = Set.of("Lord", "Knight", "Maester");
        House starkHouse = new House("House Stark", roles);
        List<User> users = List.of(
                new User("Jon"),
                new User("Arya"),
                new User("Sansa"),
                new User("Bran"),
                new User("Robb"),
                new User("Rickon"),
                new User("Theon"),
                new User("Ygritte"),
                new User("Samwell"),
                new User("Gendry")
        );
        ExecutorService executor = Executors.newFixedThreadPool(THREADS_COUNT);

        for (User user : users) {
            executor.submit(() -> {
                try {
                    user.joinHouse(starkHouse);
                    Thread.sleep(4000);
                    user.leaveHouse();
                } catch (InterruptedException e) {
                    log.error("An error occurred while thread sleeping.", e);
                    throw new RuntimeException(e);
                }
            });
        }

        executor.shutdown();
        try {
            if (!executor.awaitTermination(60, TimeUnit.SECONDS)) {
                log.info("We are in trouble! Shutting down all threads!");
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            log.error("An error occurred while stopping threads");
            throw new RuntimeException(e);
        }
    }
}

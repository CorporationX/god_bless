package school.faang.sprint3.bjs2_81995;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    private static final int THREAD_BATCH = 5;

    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(THREAD_BATCH);
        List<String> roles = List.of("Role 1", "Role 2");
        House house = new House(roles);
        List<User> users = List.of(
                new User("User 1"), new User("User 2"), new User("User 3"), new User("User 4")
        );
        users.forEach(user -> executor.execute(() -> user.joinHouse(house)));

        executor.shutdown();
        try {
            if (!executor.awaitTermination(30, TimeUnit.SECONDS)) {
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            executor.shutdownNow();
            throw new RuntimeException(e);
        }
    }
}

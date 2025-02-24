package school.faang.ironthrone;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    private static final int THREADS_COUNT = 2;

    public static void main(String[] args) {
        House house = new House(new ArrayList<>(List.of("Lord", "Warrior", "Mage")));
        List<User> users = List.of(
                new User("Stanis", "Warrior"),
                new User("Rob", "Warrior"),
                new User("Peter", "Mage"),
                new User("Jamie", "Warrior"),
                new User("Nad", "Lord")
        );
        ExecutorService executor = Executors.newFixedThreadPool(THREADS_COUNT);
        users.forEach(user -> executor.execute(() -> user.joinHouse(house)));

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

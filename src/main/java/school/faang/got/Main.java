package school.faang.got;

import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Main {

    public static void main(String[] args) {
        User ivan = new User("Ivan");
        User sasha = new User("Sasha");
        User petr = new User("Petr");
        User fedor = new User("Fedor");
        List<User> users = List.of(ivan, sasha, petr, fedor);
        House lonnister = new House("Lonnister", List.of("lord", "mage", "knight"));

        ScheduledExecutorService executor = Executors.newScheduledThreadPool(3);
        users.forEach(user -> {
                    executor.submit(() -> user.joinHouse(lonnister));
                    executor.schedule(user::leaveHouse, 5, TimeUnit.SECONDS);
                }
        );
        executor.shutdown();
        try {
            if (!executor.awaitTermination(1, TimeUnit.MINUTES)) {
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            executor.shutdownNow();
        }
    }
}

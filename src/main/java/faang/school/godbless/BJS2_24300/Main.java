package faang.school.godbless.BJS2_24300;

import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {

    public static void main(String[] args) {
        House house = new House(Set.of(Role.KNIGHT, Role.MAGE, Role.LORD));
        List<User> users = List.of(
                new User("Robert"),
                new User("Denis"),
                new User("Andrey"),
                new User("Sultan"),
                new User("Mikhail")
        );

        ExecutorService executor = Executors.newFixedThreadPool(users.size());
        users.forEach(user -> executor.execute(() ->
                house.joinHouse(user, getRandomRole())
        ));

        executor.shutdown();
        try {
            if (!executor.awaitTermination(50, TimeUnit.SECONDS)) {
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            executor.shutdownNow();
        }
    }

    private static Role getRandomRole() {
        return Role.values()[new Random().nextInt(Role.values().length)];
    }
}

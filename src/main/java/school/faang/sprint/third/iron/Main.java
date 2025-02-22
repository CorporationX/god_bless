package school.faang.sprint.third.iron;

import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {
        List<User> users = List.of(
                new User("Harold", Role.MAGE),
                new User("Donald", Role.ARCHER),
                new User("Joe", Role.SOLDIER),
                new User("Dim", Role.MAGE),
                new User("Oliver", Role.ARCHER),
                new User("Susy", Role.SOLDIER)
        );
        ExecutorService executor = Executors.newFixedThreadPool(6);

        House house = new House();
        Random random = new Random();
        users.forEach(user -> executor.submit(() -> {
            user.joinHouse(house);
            try {
                Thread.sleep(random.nextInt(5000));
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            user.leaveHouse(house);
        }));

        executor.shutdown();
        try {
            if (!executor.awaitTermination(10000, TimeUnit.MILLISECONDS)){
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}

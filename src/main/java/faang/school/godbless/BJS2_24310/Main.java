package faang.school.godbless.BJS2_24310;

import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

public class Main {
    static final List<Role> allRoles = List.of(new Role("Mage"), new Role("Lord"), new Role("Knight"), new Role("Warrior"), new Role("Healer"));

    public static void main(String[] args) {
        final int NUM_THREADS = 100;
        final int USERS_COUNT = 100;
        List<House> houses = List.of(new House(20, allRoles, "Barateons"),
                new House(20, allRoles, "Starks"),
                new House(20, allRoles, "Arrens")
        );
        List<User> users = createUsers(USERS_COUNT, houses);

        ExecutorService executor = Executors.newFixedThreadPool(NUM_THREADS);
        users.forEach(user -> executor.submit(user::joinHouse));
        executor.shutdown();
        try {
            if (!executor.awaitTermination(100, TimeUnit.SECONDS)) {
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println("Something went wrong");
        }
        System.out.println("Finish");
    }

    private static List<User> createUsers(int countUsers, List<House> houses) {
        return IntStream.range(0, countUsers + 1)
                .mapToObj(i -> new User(houses.get(new Random().nextInt(houses.size())), "User_" + i))
                .toList();
    }
}

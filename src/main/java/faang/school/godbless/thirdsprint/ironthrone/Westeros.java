package faang.school.godbless.thirdsprint.ironthrone;

import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

public class Westeros {
    private static final int NUMBER_OF_USERS = 25;
    private static final int THREAD_POOL_LIMIT = NUMBER_OF_USERS;
    private static final Random random = new Random();

    public static void main(String[] args) {
        List<User> users = getUsers();
        List<House> houses = getHouses();
        addHousesAndAvailableSlots(houses);

        ExecutorService executor = Executors.newFixedThreadPool(THREAD_POOL_LIMIT);

        users.forEach(user -> executor.submit(() -> userJoinHouse(user, houses)));

        executor.shutdown();
        try {
            if (!executor.awaitTermination(2, TimeUnit.MINUTES)) {
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            executor.shutdownNow();
        }
    }

    private static void userJoinHouse(User user, List<House> houses) {
        House house = houses.get(random.nextInt(houses.size()));
        Role role = Role.values()[random.nextInt(Role.values().length)];
        user.joinHouse(house, role);
        try {
            Thread.sleep(random.nextInt(5) * 1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        user.leaveHouse();
    }

    private static List<House> getHouses() {
        return List.of(
                new House("Stark"),
                new House("Lannister"),
                new House("Targaryen")
        );
    }

    private static void addHousesAndAvailableSlots(List<House> houses) {
        for (House house : houses) {
            house.addAvailableRoles(Role.LORD, 3);
            house.addAvailableRoles(Role.KNIGHT, 4);
            house.addAvailableRoles(Role.QUEEN, 1);
            house.addAvailableRoles(Role.MAGE, 3);
            house.addAvailableRoles(Role.DRAGON_RIDER, 2);
        }
    }

    private static List<User> getUsers() {
        return IntStream.range(1, NUMBER_OF_USERS)
                .mapToObj(i -> new User("User " + i))
                .toList();
    }
}

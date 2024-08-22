package ironthrone;

import lombok.NonNull;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
    private static final int BATCH_SIZE = 50;
    private static final int BATCH_COUNT = 30;
    private static final int POOL_SIZE = 10;

    public static void main(String[] args) throws InterruptedException {
        var houses = initHouses();
        try (ExecutorService executor = Executors.newFixedThreadPool(POOL_SIZE)) {
            for (int i = 0; i < BATCH_COUNT; i++) {
                var users = getBatchOfUsers(i);
                int finalI = i;
                users.forEach(user -> executor.execute(() -> {
                    user.joinHouse(houses.get(finalI % houses.size()));
                    try {
                        Thread.sleep(300);
                        user.leaveHouse();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }));
            }
            executor.shutdown();
            executor.awaitTermination(5, TimeUnit.MINUTES);
        }
        houses.forEach(house -> {
            System.out.println(house.getName());
            house.printRolesSlot();
            System.out.println();
        });
    }

    private static List<House> initHouses() {
        List<House> houses = new ArrayList<>();
        houses.add(getHouse("Stark", List.of(1, 1, 1, 1, 1, 1)));
        houses.add(getHouse("Baratheon", List.of(1, 3, 12, 1, 10, 15)));
        houses.add(getHouse("Lannister", List.of(1, 0, 2, 1, 1, 10)));
        houses.add(getHouse("Greyjoy", List.of(1, 0, 1, 1, 3, 15)));
        houses.add(getHouse("Martell", List.of(1, 1, 7, 3, 8, 10)));
        houses.add(getHouse("Arryn", List.of(1, 0, 0, 1, 15, 10)));
        houses.add(getHouse("Tully", List.of(1, 1, 1, 1, 3, 10)));
        return houses;
    }

    private static House getHouse(@NonNull String name, @NonNull List<Integer> rolesCount) {
        var roles = HouseRole.values();
        return new House(name,
                IntStream.range(0, roles.length).boxed()
                        .collect(Collectors.toMap(
                                i -> roles[i],
                                rolesCount::get)));
    }

    private static List<User> getBatchOfUsers(int batchNum) {
        List<User> users = new ArrayList<>();
        for (int i = 0; i < BATCH_SIZE; i++) {
            users.add(new User("User" + batchNum + "_" + i));
        }
        return users;
    }
}

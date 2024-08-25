package faang.school.godbless.sprint3.ironThrone;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

public class Main {
    private static final Role[] originalRoles = Role.values();
    private static final int MAX_USERS_FOR_HOUSE = 20;

    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(MAX_USERS_FOR_HOUSE);
        List<House> houses = allHousesBuild();
        houses.stream()
                .map(Main::buildUsersListForHouse)
                .flatMap(Collection::stream)
                .forEach(user -> executor.execute(() -> joinToHouse(user)));
        executor.shutdown();
    }

    private static void joinToHouse(User user) {
        user.joinHouse();
        try {
            Thread.sleep(new Random().nextInt(1, 11) * 1000L);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        user.leaveHouse();
    }

    private static House buildHouse(int id, String name, List<Integer> quantityOfEachRole) {
        Map<Role, Integer> roles = new HashMap<>();
        IntStream.range(0, originalRoles.length)
                .forEach(index -> roles.put(originalRoles[index], quantityOfEachRole.get(index)));
        int quantityOfRoles = quantityOfEachRole.stream()
                .mapToInt(quantity -> quantity).sum();
        return new House(id, name, roles, quantityOfRoles);
    }

    private static List<User> buildUsersListForHouse(House house) {
        List<User> usersForHouse = new ArrayList<>();
        int begin = (MAX_USERS_FOR_HOUSE * house.getHouseId()) - MAX_USERS_FOR_HOUSE + 1;
        int end = MAX_USERS_FOR_HOUSE * house.getHouseId();
        IntStream.rangeClosed(begin, end)
                .forEach(id -> usersForHouse.add(new User(String.format("User %d", id), house)));
        return usersForHouse;
    }

    private static List<House> allHousesBuild() {
        House stark = buildHouse(1, "Старк", List.of(1, 1, 4, 1, 2));
        House lanister = buildHouse(2, "Ланистер", List.of(1, 1, 3, 1, 3));
        return List.of(stark, lanister);
    }
}

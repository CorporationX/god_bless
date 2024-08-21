package faang.school.godbless.task.multithreading.iron.throne;

import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

@Slf4j
public class Main {
    private static final int NUMBER_OF_USERS = 25;
    private static final int THREAD_POOL_LIMIT = NUMBER_OF_USERS;
    private static final int USER_IN_ROLE_TIME = 3000;

    private static final Random random = new Random();
    private static final ExecutorService executor = Executors.newFixedThreadPool(THREAD_POOL_LIMIT);

    public static void main(String[] args) {
        var users = getUsers();
        var houses = getHouses();
        users.forEach(user -> executor.submit(() -> userJoinHouse(user, houses)));
        executor.shutdown();
    }

    private static void userJoinHouse(User user, List<House> houses) {
        var house = houses.get(random.nextInt(houses.size()));
        log.info("Пользователь {} наугад выбирает дом {}", user.getName(), house.getName());
        user.joinHouse(house);
        waitUserInRole();
        user.leaveHouse();
    }

    private static void waitUserInRole() {
        try {
            Thread.sleep(USER_IN_ROLE_TIME);
        } catch (InterruptedException exception) {
            log.error("Interrupted exception {}", exception.getMessage());
            Thread.currentThread().interrupt();
        }
    }

    private static List<House> getHouses() {
        return List.of(
                new House("Баратеон"),
                new House("Старк"),
                new House("Ланистер")
        );
    }

    private static List<User> getUsers() {
        return IntStream.rangeClosed(1, NUMBER_OF_USERS)
                .mapToObj(i -> new User("User " + i))
                .toList();
    }
}

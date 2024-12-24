package school.faang.sprint3.task_48906;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

public class Main {
    private static final int THREAD_POOL_SIZE = 5;
    private static final int USERS_NUMBER = 5;

    public static void main(String[] args) {
        House house = new House();
        User user1 = new User("Dmitry");
        User user2 = new User("Maksim");

        house.printRoles();

        ArrayList<User> users = new ArrayList<>();

        IntStream.range(0, USERS_NUMBER)
                .forEach((i) -> users.add(new User("name-" + i)));

        ExecutorService executorService = Executors.newFixedThreadPool(THREAD_POOL_SIZE);

        ArrayList<Role> roles = new ArrayList<>(List.of(Role.values()));
        Random random = new Random();

        users.stream()
                .forEach((user) -> executorService.submit(() ->
                        user.joinHouse(house, roles.get(random.nextInt(roles.size())))));

        try {
            Thread.sleep(50);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        house.printRoles();

        for (User user : users) {
            if (random.nextBoolean()) {
                executorService.submit(() -> user.leaveHouse());
            }
        }

        executorService.shutdown();
    }
}

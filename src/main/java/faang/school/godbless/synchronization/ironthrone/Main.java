package faang.school.godbless.synchronization.ironthrone;

import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

public class Main {
    private static final int DEFAULT_USERS_NUM = 10;

    public static void main(String[] args) {
        House house = new House("House 1");

        List<User> users = generateUsers();

        ExecutorService executorService = Executors.newCachedThreadPool();

        users.forEach(user -> {
            executorService.execute(() -> {
                try {
                    user.joinHouse(house);
                    Thread.sleep(1000L * new Random().nextInt(5));
                    user.leaveHouse();
                } catch (InterruptedException ex) {
                    throw new RuntimeException();
                }
            });
        });

        executorService.shutdown();
    }

    private static List<User> generateUsers() {
        return IntStream.rangeClosed(1, DEFAULT_USERS_NUM)
                .boxed()
                .map(i -> new User("User " + i))
                .toList();
    }
}

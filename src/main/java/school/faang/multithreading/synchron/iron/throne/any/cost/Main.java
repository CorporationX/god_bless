package school.faang.multithreading.synchron.iron.throne.any.cost;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    private final static int THREAD_POOL_SIZE = 5;

    public static void main(String[] args) throws InterruptedException {
        House house = new House(Arrays.asList("лорд", "рыцарь", "маг"));

        User user1 = new User("user1", "лорд");
        User user2 = new User("user2", "рыцарь");
        User user3 = new User("user3", "маг");
        User user4 = new User("user4", "лорд");
        User user5 = new User("user5", "рыцарь");
        User user6 = new User("user6", "маг");

        List<User> users = Arrays.asList(user1, user2, user3, user4, user5, user6);
        ExecutorService service = Executors.newFixedThreadPool(THREAD_POOL_SIZE);

        users.forEach(user -> {
            service.submit(() -> user.joinHouse(house));
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            user.leaveHouse(house);
        });

        service.shutdown();
        if (!service.awaitTermination(60, TimeUnit.SECONDS)) {
            service.shutdownNow();
        }
    }
}

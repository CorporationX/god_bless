package school.faang.task_48816;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    private static final int THREAD_POOL_SIZE = 5;

    public static void main(String[] args) {
        List<String> starkHouseRoles = Arrays.asList("Lord", "Knight", "Mage");
        House starkHouse = new House("Stark", starkHouseRoles);
        List<User> userList = Arrays.asList(
                new User("John"),
                new User("Arya"),
                new User("Sansa"),
                new User("Isaac"));
        ExecutorService executor = Executors.newFixedThreadPool(THREAD_POOL_SIZE);

        for (User user : userList) {
            executor.submit(() -> {
                user.joinHouse(starkHouse);
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    System.out.println("Произошла ошибка");
                }
                user.leaveHouse();
            });
        }

        executor.shutdown();
        try {
            if (!executor.awaitTermination(60, TimeUnit.SECONDS)) {
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            executor.shutdownNow();
        }
    }
}

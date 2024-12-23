package school.faang.task_48905;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {

        ExecutorService executors = Executors.newCachedThreadPool();
        List<Role> starkHouseRoles = new ArrayList<>(Arrays.asList(Role.LORD, Role.MAGE, Role.KNIGHT));
        House starkHouse = new House(starkHouseRoles, "Stark");

        List<User> userList = Arrays.asList(
                new User("Sansa"),
                new User("Rickon"),
                new User("John"),
                new User("Brandon")
        );

        for (User user : userList) {
            executors.submit(() -> {
                try {
                    user.joinHouse(starkHouse);
                    Thread.sleep(1000);
                    user.leaveHouse();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            });
        }

        executors.shutdown();

        try {
            if (!executors.awaitTermination(30, TimeUnit.SECONDS)) {
                executors.shutdownNow();
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
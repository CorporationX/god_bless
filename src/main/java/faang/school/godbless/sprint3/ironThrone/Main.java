package faang.school.godbless.sprint3.ironThrone;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        try {
            User user1 = new User("user1");
            User user2 = new User("user2");
            User user3 = new User("user3");
            User user4 = new User("user4");
            User user5 = new User("user5");

            List<User> users = Arrays.asList(user1, user2, user3, user4, user5);

            House house = new House("house 1", Arrays.asList(Role.LORD, Role.MAGE), 2);

            ExecutorService executorService = Executors.newFixedThreadPool(5);

            users.forEach((user) -> {
                executorService.submit(() -> user.joinHouse(house, Role.LORD));
            });

            Thread.sleep(3000);

            executorService.submit(user1::leaveHouse);
            executorService.submit(user2::leaveHouse);


            executorService.shutdown();

            if (!executorService.awaitTermination(10L, TimeUnit.SECONDS)) {
                System.out.println("Didn't wait result");
                executorService.shutdownNow();
            } else {
                System.out.println("Threads has been done");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

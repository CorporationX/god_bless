package faang.school.godbless.BJS2_1281;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {
        House house = new House("Huge House");

        User user1 = new User("user1", house);
        User user2 = new User("user2", house);
        User user3 = new User("user3", house);
        User user4 = new User("user4", house);

        ExecutorService executor = Executors.newFixedThreadPool(4);

        executor.submit(() -> user1.joinHouse(Role.KNIGHT));
        executor.submit(() -> user2.joinHouse(Role.LORD));
        executor.submit(() -> user3.joinHouse(Role.MAGE));
        executor.submit(() -> user4.joinHouse(Role.LORD));

        try {
            executor.awaitTermination(1, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        executor.submit(() -> user1.leaveHouse());
        executor.submit(() -> user2.leaveHouse());
        executor.submit(() -> user3.leaveHouse());
        executor.submit(() -> user4.leaveHouse());

        executor.shutdown();
    }
}
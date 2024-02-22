package faang.school.godbless.ironthrone;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newCachedThreadPool();
        House house = new House("Stark");
        house.addNewRole("Lord");
        house.addNewRole("Knight");
        house.addNewRole("Mage");
        User user1 = new User("User 1");
        User user2 = new User("User 2");
        User user3 = new User("User 3");
        User user4 = new User("User 4");
        User user5 = new User("User 5");
        executorService.execute(() -> user1.joinHouse("Lord", house));
        executorService.execute(() -> user2.joinHouse("Knight", house));
        executorService.execute(() -> user3.joinHouse("Mage", house));
        executorService.execute(() -> user4.joinHouse("Lord", house));
        executorService.execute(() -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            user1.leaveHouse();
        });
        executorService.execute(() -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            user4.leaveHouse();
        });
        executorService.execute(() -> user5.joinHouse("Knight", house));
        executorService.shutdown();
        executorService.awaitTermination(Long.MAX_VALUE, TimeUnit.SECONDS);
    }
}

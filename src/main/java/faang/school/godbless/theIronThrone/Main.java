package faang.school.godbless.theIronThrone;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        House house = new House("Stark");
        house.addRole("Lord");
        house.addRole("Knight");
        house.addRole("Teacher");

        User user1 = new User("Jon");
        User user2 = new User("Arya");
        User user3 = new User("Bran");
        User user4 = new User("Robb");

        ExecutorService executorService = Executors.newFixedThreadPool(4);
        executorService.submit(() -> user1.joinHouse(house));
        executorService.submit(() -> user2.joinHouse(house));
        executorService.submit(() -> user3.joinHouse(house));
        executorService.submit(() -> user4.joinHouse(house));

        executorService.submit(() -> user1.leaveHouse());
        executorService.shutdown();
        executorService.awaitTermination(20, TimeUnit.SECONDS);
    }
}

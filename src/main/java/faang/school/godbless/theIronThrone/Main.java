package faang.school.godbless.theIronThrone;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        House house = new House("Stark");
        house.getRoles().put("Lord", 1);
        house.getRoles().put("Knight", 1);
        house.getRoles().put("Teacher", 1);

        User user1 = new User("Jon");
        User user2 = new User("Arya");
        User user3 = new User("Bran");
        User user4 = new User("Robb");

        ExecutorService executorService = Executors.newFixedThreadPool(4);
        executorService.submit(() -> user1.joinHouse(house, "Lord"));
        executorService.submit(() -> user2.joinHouse(house, "Knight"));
        executorService.submit(() -> user3.joinHouse(house, "Teacher"));
        executorService.submit(() -> user4.joinHouse(house, "Lord"));

        executorService.submit(() -> user1.leaveHouse(house));
        executorService.shutdown();
        try {
            executorService.awaitTermination(10, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}

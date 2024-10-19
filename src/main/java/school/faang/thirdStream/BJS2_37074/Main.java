package school.faang.thirdStream.BJS2_37074;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {
        House house = new House("Stark");

        User user1 = new User("User1");
        User user2 = new User("User2");
        User user3 = new User("User3");
        User user4 = new User("User4");

        ExecutorService executor = Executors.newCachedThreadPool();
        executor.execute(() -> user1.joinHouse(house, Role.LORD));
        executor.execute(() -> user2.joinHouse(house, Role.KNIGHT));
        executor.execute(() -> user3.joinHouse(house, Role.MAGE));
        executor.execute(() -> user4.joinHouse(house, Role.LORD));
        executor.execute(user1::leaveHouse);
        executor.execute(user2::leaveHouse);

        executor.shutdown();

        try {
            if (!executor.awaitTermination(20, TimeUnit.SECONDS)) {
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            throw new IllegalStateException("Thread has been interrupted " + e.getMessage());
        }
    }
}

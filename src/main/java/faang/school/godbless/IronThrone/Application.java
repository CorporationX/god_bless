package faang.school.godbless.IronThrone;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Application {
    public static void main(String[] args) {
        House house = new House(new ArrayList<>(List.of("Role1", "Role2", "Role3")), 3);

        User user1 = new User("User1");
        User user2 = new User("User2");
        User user3 = new User("User3");
        User user4 = new User("User4");
        User user5 = new User("User5");
        User user6 = new User("User6");
        User user7 = new User("User7");

        ExecutorService executorService = Executors.newFixedThreadPool(4);

        executorService.execute(() -> user1.emulateJoinLeave(house));
        executorService.execute(() -> user2.emulateJoinLeave(house));
        executorService.execute(() -> user2.emulateJoinLeave(house));
        executorService.execute(() -> user3.emulateJoinLeave(house));
        executorService.execute(() -> user4.emulateJoinLeave(house));
        executorService.execute(() -> user5.emulateJoinLeave(house));
        executorService.execute(() -> user6.emulateJoinLeave(house));
        executorService.execute(() -> user7.emulateJoinLeave(house));

        executorService.shutdown();
    }
}

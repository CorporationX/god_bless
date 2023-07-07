package faang.school.godbless.iron_throne;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        List<String> roles = new ArrayList<>(List.of("King", "Knight", "Lord", "Mag"));

        House house = new House("Vesteros", roles);

        User user1 = new User("Ivan");
        User user2 = new User("Vasya");
        User user3 = new User("Misha");
        User user4 = new User("Kolya");
        User user5 = new User("Dima");

        ExecutorService executorService = Executors.newFixedThreadPool(3);

        executorService.execute(() -> user1.joinHouse(house, "King"));
        executorService.execute(() -> user2.joinHouse(house, "Lord"));
        executorService.execute(() -> user3.joinHouse(house, "Mag"));
        executorService.execute(() -> user4.joinHouse(house, "Knight"));
        executorService.execute(() -> user5.joinHouse(house, "King"));
        Thread.sleep(2000);
        executorService.execute(() -> user1.leaveHouse());

        executorService.shutdown();

        executorService.awaitTermination(10, TimeUnit.SECONDS);
    }
}

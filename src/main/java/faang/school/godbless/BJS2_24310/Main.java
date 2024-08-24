package faang.school.godbless.BJS2_24310;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        final int NUM_THREADS = 4;
        List<User> users = createUsers(20);
        House house = new House(3, List.of(new Role("Mage"),
                new Role("Lord"), new Role("Knight")));

        User user1 = new User(house, "Kolobok");
        User user2 = new User(house, "Fox");
        User user3 = new User(house, "Bear");
        User user4 = new User(house, "Wolf");

        ExecutorService executor = Executors.newFixedThreadPool(NUM_THREADS);
        executor.submit(user1::joinHouse);
        executor.submit(user2::joinHouse);
        executor.submit(user3::joinHouse);
        executor.submit(user4::joinHouse);

        sleep(4000);
        user1.leaveHouse();
        sleep(2000);
        executor.shutdown();
        try {
            if (!executor.awaitTermination(10, TimeUnit.SECONDS)) {
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    private static List<User> createUsers(int countUsers) {
return IntStream.range(0,countUsers)
        .forEach(new User());
    }



    private static void sleep(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}

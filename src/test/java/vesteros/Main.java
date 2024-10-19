package vesteros;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Slf4j
public class Main {
    public static void main(String[] args) {
        List<String> positions = new ArrayList<>();
        positions.add("Lord");
        positions.add("Knight");
        positions.add("Mage");
        House starkHouse = new House(positions);
        User user1 = new User("Jon Snow");
        User user2 = new User("Arya Stark");
        User user3 = new User("Bran Stark");
        User user4 = new User("Tyrion Lannister");
        List<User> users = Arrays.asList(user1, user2, user3, user4);

        ExecutorService executorService = Executors.newFixedThreadPool(users.size());
        for (User user : users) {
            executorService.submit(() -> {
                user.setUserHouse(starkHouse);
                user.run();
            });
        }
        executorService.shutdown();
        try {
            if (!executorService.awaitTermination(20, TimeUnit.SECONDS)) {
                executorService.shutdownNow();
            }
        } catch (InterruptedException e) {
            System.out.println("The game is not over");
            e.printStackTrace();
        }
        System.out.println("Game over");
    }
}

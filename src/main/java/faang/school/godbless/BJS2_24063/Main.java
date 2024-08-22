package faang.school.godbless.BJS2_24063;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        House house = new House();
        User user1 = new User("Player 1");
        User user2 = new User("Player 2");
        User user3 = new User("Player 3");
        User user4 = new User("Player 4");
        User user5 = new User("Player 5");
        User user6 = new User("Player 6");
        User user7 = new User("Player 7");
        User user8 = new User("Player 8");
        User user9 = new User("Player 9");
        User user10 = new User("Player 10");

        List<User> users = new ArrayList<>(List.of(user1, user2, user3, user4, user5, user6, user7, user8, user9, user10));

        ExecutorService executorService = Executors.newFixedThreadPool(users.size());
        Random random = new Random();
        for (int i = 0; i < users.size(); i++) {
            int userId = i;
            executorService.execute(() -> {
                User user = users.get(userId);
                user.joinHouse(house);
                try {
                    Thread.sleep((random.nextInt(6) + 5) * 1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e.getMessage());
                }
                user.leaveHouse(house);
            });
        }

        executorService.shutdown();
        executorService.awaitTermination(10, TimeUnit.SECONDS);
    }
}

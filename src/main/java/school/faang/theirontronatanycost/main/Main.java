package school.faang.theirontronatanycost.main;

import school.faang.theirontronatanycost.maincode.House;
import school.faang.theirontronatanycost.maincode.User;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    private static final int THREAD_COUNT = 5;

    public static void main(String[] args) {
        House house = new House(Arrays.asList("Мечник", "Лучник", "Рыцарь", "Копейщик"));

        User user1 = new User("user1", "Мечник");
        User user2 = new User("user2", "Рыцарь");
        User user3 = new User("user3", "Лучник");
        User user4 = new User("user4", "Мечник");
        User user5 = new User("user5", "Рыцарь");
        User user6 = new User("user6", "Лучник");
        User user7 = new User("user7", "Копейщик");
        User user8 = new User("user8", "Копейщик");

        List<User> users = Arrays.asList(user1, user2, user3, user4, user5, user6, user7, user8);

        ExecutorService executor = Executors.newFixedThreadPool(THREAD_COUNT);

        users.forEach(user -> {
            executor.submit(() -> {
                user.joinHouse(house);
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                user.leaveHouse(house);
            });
        });

        executor.shutdown();

        try {
            if (executor.awaitTermination(2, TimeUnit.MINUTES)) {
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            executor.shutdownNow();
        }
    }
}

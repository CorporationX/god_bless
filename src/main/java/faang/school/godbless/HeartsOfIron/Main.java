package faang.school.godbless.HeartsOfIron;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {
        House house = new House();
        List<User> users = new ArrayList<>();

        house.addRole("CYBORG");
        house.addRole("OLEBORG");
        User user1 = new User("valera");
        users.add(user1);
        User user2 = new User("auf");
        users.add(user2);
        User user3 = new User("aulele");
        users.add(user3);
        User user4 = new User("vava");
        users.add(user4);

        Runnable session = () -> {
            users.forEach(user -> {
                user.joinHouse(house);
                try {
                    Thread.sleep(new Random().nextInt(6) * 1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                user.leaveHouse();
            });
        };

        ExecutorService executorService = Executors.newFixedThreadPool(2);
        for (int i = 0; i < 2; i++) {
            executorService.execute(session);
        }

        executorService.shutdown();
        try {
            if (!executorService.awaitTermination(1, TimeUnit.HOURS)) {
                executorService.shutdownNow();
            }
            System.out.println("изи вырубили");
        } catch (InterruptedException e) {
            System.out.println("КОНЕЦ");
            throw new RuntimeException(e);
        }
    }
}

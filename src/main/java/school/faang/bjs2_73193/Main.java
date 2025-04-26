package school.faang.bjs2_73193;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {

    public static void main(String[] args) {
        List<Role> roles = List.of(Role.RULER, Role.SERVANT, Role.KNIGHT, Role.BUTLER);
        House house = new House(roles);

        List<User> users = List.of(
                new User("Rob"),
                new User("Tom"),
                new User("Jared"),
                new User("Karen"),
                new User("Smit"),
                new User("Walt")
        );

        ExecutorService executor = Executors.newCachedThreadPool();

        for (User user : users) {
            executor.execute(() -> {
                user.joinHouse(house);
                try {
                    Thread.sleep(4000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                user.leaveHouse(house);
            });
        }

        executor.shutdown();

        try {
            if (!executor.awaitTermination(5, TimeUnit.MINUTES)) {
                System.out.println("Задачи не завершились за 5 минут, принудительно останавливаем...");
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            executor.shutdownNow();
        }
    }
}

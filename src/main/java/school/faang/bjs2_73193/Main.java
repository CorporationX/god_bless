package school.faang.bjs2_73193;

import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Slf4j
public class Main {

    private static final int TIMEOUT = 5;

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
                    Thread.currentThread().interrupt();
                    throw new RuntimeException(e);
                }
                user.leaveHouse(house);
            });
        }

        terminateExecutor(executor);
    }

    private static void terminateExecutor(ExecutorService executor) {
        executor.shutdown();

        try {
            if (!executor.awaitTermination(TIMEOUT, TimeUnit.MINUTES)) {
                log.info("Задачи не завершились за {} минут, принудительно останавливаем...", TIMEOUT);
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            executor.shutdownNow();
        }
    }
}

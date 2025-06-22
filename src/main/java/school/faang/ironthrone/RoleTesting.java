package school.faang.ironthrone;

import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

@Slf4j
public class RoleTesting {
    private static final List<User> USERS = List.of(new User("Robert"), new User("Joseph"), new User("Andrew"),
            new User("Tomas"), new User("Katy"), new User("Elizabeth"), new User("Ella"));
    private static final int THREAD_COUNT = 3;

    public static void main(String[] args) {
        House house = new House("Barateon");

        ExecutorService executor = Executors.newFixedThreadPool(THREAD_COUNT);

        for (User user : USERS) {
            int randomIndex = ThreadLocalRandom.current().nextInt(house.getRoles().size());
            String someRole = house.getRoles().get(randomIndex);
            executor.submit(() -> {
                user.joinHouse(house, someRole);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    log.error("Поток был прерван во время ожидания.");
                } finally {
                    user.leaveHouse();
                }
            });
        }

        executor.shutdown();

        try {
            if (!executor.awaitTermination(1, TimeUnit.MINUTES)) {
                log.info("Задачи не завершились за 1 минуту, принудительная остановка.");
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            executor.shutdownNow();
        }
    }
}

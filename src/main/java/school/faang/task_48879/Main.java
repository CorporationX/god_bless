package school.faang.task_48879;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Slf4j
public class Main {
    private static final int NUMBER_OF_USERS = 10;
    private static final int USER_IN_HOUSE_TIME = 1000;
    private static final int AWAIT_DELAY = 1;

    public static void main(String[] args) {
        List<Role> roles = Arrays.asList(Role.DRAGON, Role.DRUID, Role.KNIGHT, Role.LORD, Role.MAGE);
        House house = new House("House 1", roles);

        ExecutorService executorService = Executors.newCachedThreadPool();

        for (int i = 1; i <= NUMBER_OF_USERS; i++) {
            User user = new User("User " + i);
            executorService.submit(() -> {
                try {
                    user.joinHouse(house);
                    Thread.sleep(USER_IN_HOUSE_TIME);
                    user.leaveHouse();
                } catch (InterruptedException e) {
                    log.info("Поток {} был прерван при выполнеии метода sleep()", Thread.currentThread().getName());
                    Thread.currentThread().interrupt();
                }
            });
        }

        executorService.shutdown();

        try {
            if (!executorService.awaitTermination(AWAIT_DELAY, TimeUnit.MINUTES)) {
                log.info("Время ожидания вышло. Принудительно завершаем работу...");
                executorService.shutdownNow();
            }
        } catch (InterruptedException e) {
            log.error("Поток был прерван при выполнении метода awaitTermination()", e);
            executorService.shutdownNow();
            Thread.currentThread().interrupt();
        }

        log.info("Количество свободных ролей = {}", house.getCurrentAvailableRoles());
    }
}

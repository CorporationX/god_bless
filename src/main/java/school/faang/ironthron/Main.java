package school.faang.ironthron;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Slf4j
public class Main {
    public static void main(String[] args) {

        List<User> users = new ArrayList<>();
        users.add(new User("Тирион", null));
        users.add(new User("Дайнерис", null));
        users.add(new User("Ария", null));
        users.add(new User("Санса", null));
        users.add(new User("Серсея", null));
        users.add(new User("Джон", null));

        House house = new House(new ArrayList<>(List.of("маг", "лорд", "рыцарь")));

        ExecutorService executorService = Executors.newCachedThreadPool();

        for (User user : users) {
            executorService.execute(() -> {
                user.joinHouse(house);
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    log.debug("Поток был прерван", e);
                    Thread.currentThread().interrupt();
                    throw new RuntimeException(e);
                }

                user.leaveHouse(house);
            });
        }
        executorService.shutdown();

        try {
            if (!executorService.awaitTermination(1, TimeUnit.MINUTES)) {
                executorService.shutdownNow();
            }
        } catch (InterruptedException e) {
            log.debug("Во время ожидания поток был прерван", e);
            Thread.currentThread().interrupt();
        }
    }
}

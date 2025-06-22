package school.faang.bjs2_81987;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Slf4j
public class Main {
    private static final int NUM_THREAD = 4;
    private static final int NUM_USERS = 15;
    private static final int TIMEOUT = 100;

    public static void main(String[] args) {
        List<RoleOfHouse> roles = new ArrayList<>(
                List.of(RoleOfHouse.LORD, RoleOfHouse.MAGICIAN, RoleOfHouse.ARCHER, RoleOfHouse.KNIGHT));
        House house = new House(roles);
        ExecutorService executor = Executors.newFixedThreadPool(NUM_THREAD);

        for (int i = 0; i < NUM_USERS; i++) {
            User user = new User(1L, "User %d".formatted(i), RoleOfHouse.DEFAULT);
            executor.submit(() -> {
                user.joinHouse(house);
                log.info("Пользователь {} находится в доме", user.getName());
                try {
                    TimeUnit.SECONDS.sleep(2);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                user.leaveHouse(house);
            });
        }

        executor.shutdown();
        try {
            if (!executor.awaitTermination(TIMEOUT, TimeUnit.SECONDS)) {
                log.info("Выполняется завершение задач досрочно");
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            executor.shutdownNow();
        }
    }
}

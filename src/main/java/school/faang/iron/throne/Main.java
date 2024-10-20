package school.faang.iron.throne;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Slf4j
public class Main {
    private static final int NUMBER_OF_USER = 7;

    public static void main(String[] args) {
        List<String> availableRoles =
                new ArrayList<>(List.of("Queen", "King", "Warrior", "Prince", "Knight"));
        House house = new House(availableRoles);
        ExecutorService executor = Executors.newFixedThreadPool(NUMBER_OF_USER);
        for (int i = 0; i < NUMBER_OF_USER; i++) {
            User user = new User("user_" + i);
            executor.submit(() -> {
                user.joinHouse(house);
                try {
                    Thread.sleep(6_000);
                } catch (InterruptedException e) {
                    log.error(e.getMessage());
                    log.error(Arrays.toString(e.getStackTrace()));
                }
                user.leaveHouse();
            });
        }

        executor.shutdown();
        try {
            if (executor.awaitTermination(1, TimeUnit.MINUTES)) {
                System.out.println("Все задачи успешно завершили работу");
            }
        } catch (InterruptedException e) {
            log.error(e.getMessage());
            log.error(Arrays.toString(e.getStackTrace()));
        }
    }
}

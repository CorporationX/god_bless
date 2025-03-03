package school.faang.BJS2_61470;

import lombok.extern.slf4j.Slf4j;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Slf4j
public class Main {


    public static void main(String[] args) {
        List<User> users = new ArrayList<>();
        for (int i = 0; i < 15; i++) {
            users.add(new User("Player_" + i));
        }
        House house = new House("Vesteros", new ArrayList<>(Arrays.asList("Lord", "Knight", "Magician")));

        ExecutorService executorService = Executors.newFixedThreadPool(10);
        for (User user : users) {
            executorService.submit(() -> {
                try {
                    user.joinHouse(house);
                    Thread.sleep(ConstAndMessages.TIMEOUT_ROLE);
                } catch (InterruptedException e) {
                    log.error(ConstAndMessages.ERROR_OF_WAITING_ROLE);
                    Thread.currentThread().interrupt();
                    throw new RuntimeException(e);
                } finally {
                    user.leaveHouse();
                }
            });
        }
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        executorService.shutdown();
        try {
            if (!executorService.awaitTermination(ConstAndMessages.TIMEOUT_SHUTDOWN, TimeUnit.SECONDS)) {
                executorService.shutdownNow();
            }
        } catch (InterruptedException e) {
            executorService.shutdownNow();
        }
    }
}

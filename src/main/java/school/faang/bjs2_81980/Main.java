package school.faang.bjs2_81980;

import lombok.extern.slf4j.Slf4j;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Slf4j
public class Main {
    private static House house = new House(new ArrayList<>(List.of("lord", "lordRightHand", "magister")));

    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(4);
        List<User> users = List.of(new User("Анна"),
                                   new User("Иван"),
                                   new User("Инна"),
                                   new User("Олег"));
        try {
            users.forEach(user -> executor.execute(() -> spendTimeInHouse(user)));

            executor.shutdown();

            if (!executor.awaitTermination(10, TimeUnit.SECONDS)) {
                log.info("Еще не все задачи завершены");
                executor.shutdownNow();
            }
        } catch (InterruptedException | RuntimeException e) {
            log.error("Поток был прерван", e);
            Thread.currentThread().interrupt();
            executor.shutdownNow();
        }
        log.info("Все задачи завершены");
    }

    private static void spendTimeInHouse(User user) {
        try {
            user.joinHouse(house);
            Thread.sleep(3000);
            user.leaveHouse();

        } catch (InterruptedException e) {
            log.error("Поток был прерван");
            Thread.currentThread().interrupt();
        }
    }
}

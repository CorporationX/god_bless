package school.faang.sprint3.bjs_48809;

import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Slf4j
public class Main {
    public static void main(String[] args) {
        List<String> rolesList = List.of("Lord", "Wizard", "Knight");
        int threadAmount = 5;
        int timeOut = 1;
        int timeToLeave = 200;

        List<User> users = List.of(
                new User("User1"),
                new User("User2"),
                new User("User3"),
                new User("User4"),
                new User("User5"));

        House house = new House(rolesList);

        ExecutorService executorService = Executors.newFixedThreadPool(threadAmount);
        users.forEach(user -> executorService.execute(() -> {
            try {
                user.joinHouse(house);
                Thread.sleep(timeToLeave);
                user.leaveHouse(house);
            } catch (InterruptedException e) {
                log.error("Unexpected error");
            }
        }));

        executorService.shutdown();
        try {
            if (!executorService.awaitTermination(timeOut, TimeUnit.MINUTES)) {
                log.warn("Not all threads stopped by themselves");
            }
        } catch (InterruptedException e) {
            log.error("Threads forced to stopped");
        } finally {
            executorService.shutdownNow();
        }
    }
}

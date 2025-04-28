package bjs2_73222_The_Iron_Throne_at_any_cost;

import lombok.extern.slf4j.Slf4j;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Slf4j
public class Main {
    public static void main(String[] args) {
        House starkHouse = new House(List.of("Lord", "diplomat"));

        List<User> users = List.of(new User("Jack"),
                new User("Alex"),
                new User("Albert"));

        ExecutorService executor = Executors.newCachedThreadPool();

        for (User user : users) {
            user.setHouse(starkHouse);
            executor.submit(() -> {
                try {
                    user.joinHouse(starkHouse);
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    log.info("couldn't add {} to {}", user.getName(), starkHouse);
                    Thread.currentThread().interrupt();
                    throw new IllegalStateException("the method was interrupted");
                }
                user.leaveHouse();
            });
        }

        executor.shutdown();

        log.info("The program is completed!");
    }
}

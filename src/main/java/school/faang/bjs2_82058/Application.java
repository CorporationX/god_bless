package school.faang.bjs2_82058;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.List;

@Slf4j
public class Application {
    public static void main(String[] args) {
        List<String> roles = Arrays.asList("Lord", "Knight", "Magician");
        House house = new House(roles);

        for (int i = 1; i <= 6; i++) {
            String userName = "User " + i;

            Thread userThread = new Thread(() -> {
                User user = new User(userName);
                user.joinHouse(house);

                try {
                    Thread.sleep((long) (1000 + Math.random() * 2000));
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    log.warn("{} was interrupted during house activity", userName);
                }

                user.leaveHouse(house);
            });

            userThread.start();
        }

        log.info("All users have been sent to battle for Westeros...");
    }
}

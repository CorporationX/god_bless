package got;

import lombok.extern.slf4j.Slf4j;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.ArrayList;
import java.util.List;

@Slf4j
public class Main {
    public static void main(String[] args) {
        Set<String> roles = new HashSet<>(Arrays.asList("Lord", "Knight", "Mage"));
        House house = new House(roles);

        List<Thread> threads = new ArrayList<>();
        for (int i = 1; i <= 10; i++) {
            User user = new User("User" + i, house);
            Thread t = new Thread(user, "UserThread-" + i);
            threads.add(t);
            t.start();
        }

        for (Thread t : threads) {
            try {
                t.join();
            } catch (InterruptedException e) {
                log.error("Main thread interrupted", e);
                Thread.currentThread().interrupt();
            }
        }

        log.info("All users have left the house. All roles are free.");
    }
}

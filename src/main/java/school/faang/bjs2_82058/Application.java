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
            Thread userThread = new Thread(new User("User " + i, house));
            userThread.start();
        }

        log.info("All users have been sent to battle for Westeros...");
    }
}
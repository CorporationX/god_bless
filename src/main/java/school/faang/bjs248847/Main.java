package school.faang.bjs248847;

import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Slf4j
public class Main {
    public static void main(String[] args) {

        List<String> roles = List.of("Mage", "Knight", "Lord");

        User user1 = new User("John Snow");
        User user2 = new User("Arya Stark");
        User user3 = new User("Robb Stark");
        User user4 = new User("Sansa Stark");
        User user5 = new User("Bran Stark");
        User user6 = new User("Rickon Stark");

        House starkHouse = new House(roles);

        List.of(user1, user2, user3, user4, user5, user6).forEach(user -> {
            Thread thread = new Thread(() -> user.joinHouse(starkHouse));
            thread.start();
            try {
                thread.join();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                log.error("Thread was interrupted", e);
            }
        });
    }
}

package ironthrone;

import lombok.extern.slf4j.Slf4j;

import java.util.Set;

@Slf4j
public class Main {
    private static final String MSG_GAME_FINISHED = "All players have finished the game!";
    private static final String MSG_THREAD_INTERRUPTION = "Main thread was interrupted!";

    public static void main(String[] args) {
        Set<String> roles = Set.of("Lord", "Knight", "Mage");
        House starkHouse = new House("Stark", roles);

        Set<User> users = Set.of(
                new User("Jon", starkHouse),
                new User("Arya", starkHouse),
                new User("Sansa", starkHouse),
                new User("Bran", starkHouse)
        );

        users.forEach(Thread::start);

        users.forEach(user -> {
            try {
                user.join();
            } catch (InterruptedException e) {
                log.error(MSG_THREAD_INTERRUPTION, e);
                Thread.currentThread().interrupt();
                throw new RuntimeException(MSG_THREAD_INTERRUPTION, e);
            }
        });
        log.info(MSG_GAME_FINISHED);
    }
}

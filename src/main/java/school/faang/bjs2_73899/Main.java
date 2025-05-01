package school.faang.bjs2_73899;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Main {
    private static final int NUM_THREADS = 5;
    private static final long SLEEP_TIME = 5_000;
    private static final long WAIT_TIME = 10_000;
    private static final ExecutorService EXECUTOR_SERVICE = Executors.newFixedThreadPool(NUM_THREADS);
    private static final UserList users = new UserList();

    public static void main(String[] args) {
        users.addUser(new User("Max", true, true, false));
        users.addUser(new User("Kit", true, true, false));
        users.addUser(new User("Cat", true, true, false));
        users.addUser(new User("Sam", true, true, false));
        users.addUser(new User("Kir", true, true, false));

        ChatManager chatManager = new ChatManager(users);

        for (User user : users.getAllUsers()) {
            if (user.isInChat()) {
                continue;
            }

            EXECUTOR_SERVICE.submit(() -> {
                chatManager.startChat(user);
                try {
                    Thread.sleep(SLEEP_TIME);
                } catch (InterruptedException e) {
                    log.error("Thread was interrupted in main. {}", e.getStackTrace().toString());
                    e.getCause();
                    Thread.currentThread().interrupt();
                }
                chatManager.endChat(user);
            });
        }

        EXECUTOR_SERVICE.shutdown();
        try {
            EXECUTOR_SERVICE.awaitTermination(WAIT_TIME, TimeUnit.MICROSECONDS);
            EXECUTOR_SERVICE.shutdownNow();
        } catch (InterruptedException e) {
            log.error("Thread was interrupted by timeout. {}", e.getMessage());
            Thread.currentThread().interrupt();
        }

    }
}

package school.faang.bjs2_81786;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Slf4j
public class Main {
    private static final int NUM_THREADS = 10;
    private static final int CHATTING_IN_SEC = 3;
    private static final int TIMEOUT_IN_SEC = 20;

    public static void main(String[] args) {
        ExecutorService poolThreads = Executors.newFixedThreadPool(NUM_THREADS);
        Random random = new Random();

        User user1 = new User("Steve", true, false);
        User user2 = new User("Alice", true, true);
        User user3 = new User("John", false, false);
        User user4 = new User("Mike", true, true);
        User user5 = new User("Nick", true, true);
        User user6 = new User("Ivi", true, true);
        User user7 = new User("Kail", true, true);

        UserList userList = new UserList(new ArrayList<>(List.of(user1, user2, user3, user4, user5, user6, user7)));

        ChatManager chatManager = new ChatManager(userList);
        List<User> users = userList.getUsers();


        for (User user : users) {
            if (user.isEligible()) {
                poolThreads.submit(() -> {
                    chatManager.startChat(user);
                    try {
                        log.info("Чат создан!");
                        TimeUnit.SECONDS.sleep(CHATTING_IN_SEC - random.nextInt(2));
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                        log.error("Поток был прерван при общении для пользователя {}", user.getName(), e);
                        throw new RuntimeException(e);
                    } finally {
                        chatManager.endChat(user);
                    }
                });
            }
        }

        breakPoolThreads(poolThreads);
    }

    private static void breakPoolThreads(ExecutorService poolThreads) {
        poolThreads.shutdown();
        try {
            if (!poolThreads.awaitTermination(TIMEOUT_IN_SEC, TimeUnit.SECONDS)) {
                log.info("Досрочное завершение потоков");
                poolThreads.shutdownNow();
            }
        } catch (InterruptedException e) {
            log.warn("Досрочное завершение потоков", e);
            poolThreads.shutdownNow();
        }
    }
}

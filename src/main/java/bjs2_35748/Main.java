package bjs2_35748;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Slf4j
public class Main {
    private static final int TOTAL_THREADS = 5;
    private static final ExecutorService EXECUTOR_SERVICE = Executors.newFixedThreadPool(TOTAL_THREADS);

    public static void main(String[] args) throws InterruptedException {
        Queue<User> users = new ArrayDeque<>() {{
            add(new User("John", true, true));
            add(new User("Jack", true, true));
            add(new User("Jess", true, true));
        }};

        UserList userList = new UserList(users);
        ChatManager chatManager = new ChatManager(userList);

        users.forEach(user -> EXECUTOR_SERVICE.submit(() -> {
            try {
                chatManager.simulateChat(user);
            } catch (InterruptedException e) {
                log.error(e.getMessage());
                System.out.println();
            }
        }));

        EXECUTOR_SERVICE.shutdown();

        if (!EXECUTOR_SERVICE.awaitTermination(30, TimeUnit.SECONDS)) {
            EXECUTOR_SERVICE.shutdownNow();
        }
    }
}

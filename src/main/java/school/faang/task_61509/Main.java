package school.faang.task_61509;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    private static final int TIMEOUT_SLEEP = 3000;
    private static final int TIMEOUT_THREAD = 3;
    private static final int THREAD_COUNT = 2;

    public static void main(String[] args) {
        List<User> users = List.of(
                new User("A", true, true, false),
                new User("B", true, true, false),
                new User("C", false, false, false),
                new User("D", true, true, false),
                new User("F", true, false, false)
        );

        UserList userList = new UserList();
        for (User user : users) {
            userList.addUser(user);
        }

        ChatManager chatManager = new ChatManager(userList);
        ExecutorService pool = Executors.newFixedThreadPool(THREAD_COUNT);

        for (User user : userList.getUsers()) {
            if (user.isEligible()) {
                pool.submit(() -> {
                    chatManager.startChat(user);
                    try {
                        Thread.sleep(TIMEOUT_SLEEP);
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                        throw new RuntimeException(e);
                    }
                    chatManager.endChat(user);
                });
            }
        }

        pool.shutdown();
        try {
            if (!pool.awaitTermination(TIMEOUT_THREAD, TimeUnit.MINUTES)) {
                pool.shutdownNow();
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new RuntimeException(e);
        }
    }
}

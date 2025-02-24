package school.faang;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Slf4j
public class Main {
    private static final int TIMEOUT_SECONDS = 10;

    public static void main(String[] args) {
        List<User> users = new ArrayList<>(Arrays.asList(
                new User("user 1", false, true, null),
                new User("user 2", false, true, null),
                new User("user 3", false, true, null),
                new User("user 4", false, true, null),
                new User("user 5", false, true, null),
                new User("user 6", false, true, null),
                new User("user 7", false, true, null),
                new User("user 8", false, true, null)
        ));

        UserList userList = new UserList(users);
        ChatManager chatManager = new ChatManager(userList);
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        for (int i = 0; i < userList.getUsers().size() / 2; ++i) {
            userList.getUsers().get(i).setLookingForChat(false);
        }

        for (User user : userList.getUsers()) {
            executorService.submit(() -> {
                chatManager.startChat(user);
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    log.error("Sleep was interrupted.");
                    throw new RuntimeException(e);
                }
                chatManager.endChat(user);
            });
        }
        executorService.shutdown();
        try {
            if (!executorService.awaitTermination(TIMEOUT_SECONDS, TimeUnit.SECONDS)) {
                log.warn("Not all tasks have been completed on time.");
                executorService.shutdownNow();
            }
        } catch (InterruptedException e) {
            log.error("awaitTermination was interrupted.");
            executorService.shutdownNow();
            throw new RuntimeException(e);
        }
    }
}

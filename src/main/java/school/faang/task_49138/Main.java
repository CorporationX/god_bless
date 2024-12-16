package school.faang.task_49138;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Main {
    private static final int BUFFER_SIZE = 15;
    public static void main(String[] args) throws InterruptedException {
        UserList userList = new UserList(new ArrayList<>());
        ChatManager chatManager = new ChatManager(userList);

        List<User> users = new ArrayList<>(List.of(
                new User("User1", true, true),
                new User("User2", true, true),
                new User("User3", true, true),
                new User("User4", true, false),
                new User("User5", true, true),
                new User("User6", true, true),
                new User("User7", true, true)
        ));

        for (User user : users) {
            userList.addUser(user);
        }

        ExecutorService executorService = Executors.newScheduledThreadPool(BUFFER_SIZE);

        for (User user : users) {
            executorService.submit(() -> {
                try {
                    chatManager.startChat(user);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            });
        }

        if (!executorService.awaitTermination(90, TimeUnit.SECONDS)) {
            executorService.shutdown();
        }
    }
}

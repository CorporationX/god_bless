package matters.of.heart;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        List<User> users = new ArrayList<>(List.of(
            new User("Petr", true),
            new User("Natali", true),
            new User("Igor", true),
            new User("Eva", true),
            new User("Vasya", true),
            new User("Oleg", true),
            new User("Milana", true)
        ));

        UserList userList = new UserList(users);
        ChatManager chatManager = new ChatManager(userList);
        ExecutorService executorService = Executors.newCachedThreadPool();

        userList.getOnlineUsers().forEach(user -> {
            executorService.submit(() -> {
                try {
                    chatManager.startChat(user);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            });
        });

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        userList.getUsers()
            .stream()
            .filter(user -> user.getActiveChat().isPresent())
            .forEach(user -> {
                executorService.submit(() -> {
                    chatManager.endChat(user.getActiveChat().get());
                });
        });

        executorService.shutdown();
    }
}

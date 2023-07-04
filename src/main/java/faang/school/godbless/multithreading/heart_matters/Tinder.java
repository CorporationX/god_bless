package faang.school.godbless.multithreading.heart_matters;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

public class Tinder {
    public static void main(String[] args) {
        List<User> users = IntStream.rangeClosed(1, 10)
                .mapToObj(i -> new User(i, "User-" + i, true))
                .toList();

        UserList userList = new UserList(users);
        ChatManager chatManager = new ChatManager(userList);

        new Thread(() -> {
            chatManager.startChat(users.get(0));
        }).start();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            System.err.println(e.getMessage());
        }

        new Thread(() -> {
            chatManager.startChat(users.get(1));
        });
    }
}

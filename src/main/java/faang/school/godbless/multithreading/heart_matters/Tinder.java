package faang.school.godbless.multithreading.heart_matters;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

public class Tinder {
    public static void main(String[] args) throws InterruptedException {
        List<User> users = IntStream.rangeClosed(1, 10)
                .mapToObj(i -> new User(i, "User-" + i, true))
                .toList();

        UserList userList = new UserList(users);
        ChatManager chatManager = new ChatManager(userList);

        ExecutorService executorService = Executors.newFixedThreadPool(2);
        executorService.execute(() -> {
            User user = users.get(0);
            user.setWantsToChat(true);
            chatManager.startChat(user);
        });
        Thread.sleep(1000);
        executorService.execute(() -> {
            User user = users.get(1);
            user.setWantsToChat(true);
            chatManager.startChat(user);
        });

        executorService.shutdown();
    }
}

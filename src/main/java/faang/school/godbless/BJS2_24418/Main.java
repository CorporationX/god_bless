package faang.school.godbless.BJS2_24418;

import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        final int USERS_COUNT = 40;
        final int FOUNDERS_COUNT = 100;
        final int NUMS_THREADS = 20;

        UserList userList = new UserList();
        createUsers(USERS_COUNT, "User_")
                .forEach(userList::addUser);
        List<User> chatFounders = createUsers(FOUNDERS_COUNT, "Founder_");
        chatFounders.forEach(user -> {
            user.setChatting(true);
            user.setOnline(true);
        });

        ChatManager chatManager = new ChatManager(userList);
        ExecutorService executor = Executors.newFixedThreadPool(NUMS_THREADS);

        chatFounders
                .forEach(user -> executor.submit(() -> {
                    chatManager.startChat(user);
                    sleep(5000);
                    chatManager.endChat(user);
                }));

        try {
            executor.shutdown();
            if (!executor.awaitTermination(30, TimeUnit.SECONDS)) {
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new RuntimeException(e);
        }
    }

    public static List<User> createUsers(int usersCount, String userName) {
        return IntStream.range(0, usersCount)
                .mapToObj(i -> new User(i, userName + i, new Random().nextBoolean(), new Random().nextBoolean()))
                .toList();
    }

    public static void sleep(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new RuntimeException(e);
        }
    }
}

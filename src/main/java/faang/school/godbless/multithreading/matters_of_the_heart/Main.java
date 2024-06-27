package faang.school.godbless.multithreading.matters_of_the_heart;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    private static final int NUM_THREADS = 4;

    public static void main(String[] args) {
        UserList userList = new UserList(new ArrayList<>(List.of(
                new User("Миша", true),
                new User("Саша", true),
                new User("Петя", true)
        )));


        ChatManager chatManager = new ChatManager(userList);
        ExecutorService executor = Executors.newFixedThreadPool(NUM_THREADS);

        for (User user : userList.users()) {
            executor.execute(() -> chatManager.startChat(user));
        }


        executor.execute(() -> {
            User newUser = new User("Дима", true);
            chatManager.addUser(newUser);
        });

        sleepThread(3000);

        executor.execute(() -> {
            User delUser = new User("Петя", true);
            chatManager.endChat(delUser);
        });

        executor.shutdown();
        boolean isTerminated = false;
        try {
            isTerminated = executor.awaitTermination(1, TimeUnit.MINUTES);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("Все потоки завершены: " + isTerminated);
    }

    public static void sleepThread(long time) {
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}

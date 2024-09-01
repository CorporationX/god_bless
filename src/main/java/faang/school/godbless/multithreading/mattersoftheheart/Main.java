package faang.school.godbless.multithreading.mattersoftheheart;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {

    public static void main(String[] args) {

        UserList userList = new UserList();

        List<User> users = Arrays.asList(
                new User("Sasha", true, false),
                new User("Petya", false, true),
                new User("Tanya", false, true),
                new User("Nadya", false, true),
                new User("Masha", false, false),
                new User("Lena", false, true)
        );

        users.forEach(userList::addUser);
        userList.getOnlineUsers();

        ChatManager chatManager = new ChatManager();

        ExecutorService executorService = Executors.newFixedThreadPool(users.size());

        users.forEach(user -> executorService.submit(() ->
            chatManager.startChat(user)));

        executorService.shutdown();

        try {
            if (!executorService.awaitTermination(5, TimeUnit.SECONDS)) {
                executorService.shutdownNow();
            }
        } catch (InterruptedException e) {
            executorService.shutdownNow();
            Thread.currentThread().interrupt();
        }

        System.out.println("> Good Bye");
    }

}

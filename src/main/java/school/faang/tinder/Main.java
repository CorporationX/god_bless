package school.faang.tinder;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {

    private static final int THREAD_NUM = 3;
    private static final int TERMINATION_TIMEOUT = 30;
    private static final int THREAD_SLEEP_MS = 3000;

    public static void main(String[] args) {
        UserList userList = new UserList();
        ChatManager chatManager = new ChatManager(userList);

        User user1 = new User("Alice", true, true);
        User user2 = new User("Bob", true, true);
        User user3 = new User("Charlie", true, true);
        User user4 = new User("David", true, true);
        User user5 = new User("Eve", true, true);

        userList.addUser(user1);
        userList.addUser(user2);
        userList.addUser(user3);
        userList.addUser(user4);
        userList.addUser(user5);

        ExecutorService executor = Executors.newFixedThreadPool(THREAD_NUM);

        Runnable chatTask = () -> {
            User user;
            synchronized (userList) {
                if (userList.getOnlineUsers().isEmpty()) {
                    return;
                }
                user = userList.getOnlineUsers().get(0);
                userList.removeUser(user);
            }
            Chat chat = chatManager.startChat(user);
            try {
                Thread.sleep(THREAD_SLEEP_MS);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            chatManager.endChat(chat);
        };

        for (int i = 0; i < THREAD_NUM; i++) {
            executor.submit(chatTask);
        }

        executor.shutdown();
        try {
            if (!executor.awaitTermination(TERMINATION_TIMEOUT, TimeUnit.SECONDS)) {
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            executor.shutdownNow();
        }
    }
}

package faang.school.godbless.tinder;

import java.util.List;
import java.util.UUID;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class App {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(5);

        UserList userList = new UserList(List.of(
                new User(UUID.randomUUID().toString(), "Dima", true),
                new User(UUID.randomUUID().toString(), "Masha", true),
                new User(UUID.randomUUID().toString(), "Petya", false),
                new User(UUID.randomUUID().toString(), "Kolya", true),
                new User(UUID.randomUUID().toString(), "Katya", true),
                new User(UUID.randomUUID().toString(), "Roma", false),
                new User(UUID.randomUUID().toString(), "Sofia", true)
        ));
        ChatManager chatManager = new ChatManager(userList);

        List<User> onlineUsers = userList.getOnlineUsers();

        for (User user : onlineUsers) {
            executor.submit(() -> {
                try {
                    chatManager.joinRandomChat(user);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            });
        }

        List<String> chatIdsToRemove = chatManager.getChats().keySet().stream().toList();

        for (String chatId : chatIdsToRemove) {
            executor.submit(() -> {
                chatManager.endChat(chatId);
            });
        }

        executor.shutdown();
    }
}

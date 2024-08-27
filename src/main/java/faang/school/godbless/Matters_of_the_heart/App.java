package faang.school.godbless.Matters_of_the_heart;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Slf4j
public class App {
    public static void main(String[] args) {
        UserList userList = new UserList();
        ChatManager chatManager = new ChatManager(userList);

        User artem = new User("Artem", true);
        User tomas = new User("Tomas", true);
        User vladislav = new User("Vladislav", true);

        userList.addUser(artem);
        userList.addUser(tomas);
        userList.addUser(vladislav);

        ExecutorService executorService = Executors.newFixedThreadPool(4);

        executorService.execute(() -> {
            chatManager.startChat(artem);
            chatManager.waitForChat(artem);
            Chat chat = chatManager.getActiveChat(artem);
            if (chat != null) {
                chatManager.endChat(chat);
            }
        });

        executorService.execute(() -> {
            chatManager.startChat(tomas);
            chatManager.waitForChat(tomas);
        });

        executorService.execute(() -> {
            chatManager.startChat(vladislav);
            chatManager.waitForChat(vladislav);
        });

        executorService.execute(() -> {
            User newUser = new User("Maxim", true);
            userList.addUser(newUser);
            chatManager.startChat(newUser);
            chatManager.waitForChat(newUser);
        });

        executorService.shutdown();
        try {
            if (!executorService.awaitTermination(60, TimeUnit.SECONDS)) {
                executorService.shutdownNow();
            }
        } catch (InterruptedException e) {
            log.error("Пул потоков был прерван: {}", e.getMessage());
            executorService.shutdownNow();
        }
    }
}

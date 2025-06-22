package school.faang.module1.bjs2_81781;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Slf4j
public class Main {

    private static final int THREAD_COUNT = 10;

    public static void main(String[] args) {
        UserList userList = new UserList();
        ChatManager chatManager = new ChatManager(userList);
        List<User> allUsers = new ArrayList<>();

        for (int i = 1; i <= THREAD_COUNT; i++) {
            User user = new User("пользователь-" + i);
            userList.addUser(user);
            allUsers.add(user);
        }

        ExecutorService executor = Executors.newFixedThreadPool(THREAD_COUNT);

        allUsers.forEach(user -> executor.execute(() -> {
            try {
                chatManager.startChat(user);
                Chat chat = chatManager.waitForChat(user);

                if (chat != null) {
                    chat.start();
                    Thread.sleep(5000);
                    chatManager.endChat(chat);
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                log.error("Поток для {} был прерван", user.getName(), e);
            }
        }));

        executor.shutdown();

        try {
            if (!executor.awaitTermination(30, TimeUnit.SECONDS)) {
                log.warn("Не все задачи завершены, принудительное завершение");
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            executor.shutdownNow();
            log.error("Main-поток был прерван", e);
        }

        log.info("Все задачи завершены");
    }
}
package school.faang.bjs2_89937;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Slf4j
public class Main {
    private static final long CHAT_DURATION_MS = 1000L;
    private static final long TIMEOUT_SECONDS = 5L;

    public static void main(String[] args) throws InterruptedException {
        log.info("Запуск Tinder-приложения...");

        UserList userList = new UserList();
        final ChatManager chatManager = new ChatManager(userList);

        final User user1 = new User("Alice", true, false);
        final User user2 = new User("Bob", true, false);
        final User user3 = new User("Charlie", true, false);
        final User user4 = new User("Diana", true, false);

        log.info("Созданы пользователи:  Alice, Bob, Charlie, Diana");

        userList.addUser(user1);
        userList.addUser(user2);
        userList.addUser(user3);
        userList.addUser(user4);

        ExecutorService executor = Executors.newFixedThreadPool(4);

        executor.execute(() -> handleChat(chatManager, user1));
        executor.execute(() -> handleChat(chatManager, user2));
        executor.execute(() -> handleChat(chatManager, user3));
        executor.execute(() -> handleChat(chatManager, user4));

        executor.shutdown();

        if (!executor.awaitTermination(TIMEOUT_SECONDS, TimeUnit.SECONDS)) {
            log.warn("Не все чаты завершились за отведенное время");
            executor.shutdownNow();
        }

        log.info("Приложение завершило работу");
    }

    private static void handleChat(ChatManager chatManager, User user) {
        Chat chat = chatManager.startChat(user);
        if (chat != null) {
            log.info("{} начал чат с {}", user.getName(), getPartnerName(chat, user));
            try {
                Thread.sleep(CHAT_DURATION_MS);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            chatManager.endChat(user);
        }
    }

    private static String getPartnerName(Chat chat, User currentUser) {
        return chat.user1().equals(currentUser)
                ? chat.user2().getName()
                : chat.user1().getName();
    }
}
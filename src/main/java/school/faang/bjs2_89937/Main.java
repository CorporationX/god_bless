package school.faang.bjs2_89937;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Slf4j
public class Main {
    private static final long BOB_DELAY_MS = 1000L;
    private static final long TIMEOUT_SECONDS = 5L;

    public static void main(String[] args) throws InterruptedException {
        log.info("Запуск Tinder-приложения...");

        UserList userList = new UserList();
        final ChatManager chatManager = new ChatManager(userList);
        final ExecutorService executor = Executors.newFixedThreadPool(2);

        User alice = new User("Alice");
        User bob = new User("Bob");
        userList.addUser(alice);
        userList.addUser(bob);

        log.info("Созданы пользователи: {} и {}", alice.getName(), bob.getName());

        executor.submit(() -> {
            alice.setLookingForChat(true);
            Chat chat = chatManager.waitForChat(alice);
            log.info("{}: {}", alice.getName(), (chat != null ? "Нашла чат!" : "Не нашла"));
        });

        executor.submit(() -> {
            try {
                Thread.sleep(BOB_DELAY_MS);
                bob.setLookingForChat(true);
                chatManager.startChat(alice, bob);
                log.info("Чат создан: {} ↔ {}", alice.getName(), bob.getName());
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });

        executor.shutdown();
        if (!executor.awaitTermination(TIMEOUT_SECONDS, TimeUnit.SECONDS)) {
            executor.shutdownNow();
        }
        log.info("Завершено");
    }
}
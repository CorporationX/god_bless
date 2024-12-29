package school.faang.bjs249194;

import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Slf4j
public class Main {
    public static void main(String[] args) throws InterruptedException {
        ChatManager chatManager = new ChatManager();
        ExecutorService executorService = Executors.newCachedThreadPool();
        List<User> users = List.of(
                new User("ALEX", true, false),
                new User("BER", true, false),
                new User("KAT", true, false),
                new User("DAN", true, false),
                new User("IVAN", true, false),
                new User("ROBI", true, false));

        users.forEach(user -> {
            log.info("Очередь юзера - {}", user);

            executorService.submit(() -> {
                chatManager.startChat(user);
                log.info("Thread startChat is Done!");
            });

            executorService.submit(() -> {
                chatManager.waitForChat(user);
                log.info("Thread waitForChat is Done!");
            });
        });

        Thread.sleep(2000);
        log.info("SHUTDOWN");
        executorService.shutdown();
        try {
            if (!executorService.awaitTermination(1, TimeUnit.SECONDS)) {
                executorService.shutdownNow();
            }
        } catch (InterruptedException e) {
            log.error(e.getMessage(), e);
        }
        log.info("TOTAL CHATS: size={}", chatManager.getChatService().getChats().size());
        chatManager.getChatService().printChats();
    }
}

package tinder;

import lombok.extern.slf4j.Slf4j;
import java.util.ArrayList;
import java.util.List;

@Slf4j
public class Main {
    public static void main(String[] args) {
        final ChatManager chatManager = new ChatManager();

        final List<User> users = new ArrayList<>();
        users.add(new User("Sheldon"));
        users.add(new User("Leonard"));
        users.add(new User("Howard"));
        users.add(new User("Rajesh"));

        for (User user : users) {
            user.setOnline(true);
            user.setLookingForChat(true);
        }

        final List<Thread> threads = new ArrayList<>();
        for (User user : users) {
            Thread t = new Thread(() -> {
                try {
                    Chat chat = chatManager.startChat(user);
                    log.info("{} got chat: {}", user.getName(), chat);
                    Thread.sleep(1000);
                    chatManager.endChat(chat);
                } catch (InterruptedException e) {
                    log.error("Thread for {} interrupted", user.getName(), e);
                    Thread.currentThread().interrupt();
                }
            }, user.getName() + "-Thread");
            threads.add(t);
            t.start();
        }

        for (Thread t : threads) {
            try {
                t.join();
            } catch (InterruptedException e) {
                log.error("Main thread interrupted", e);
                Thread.currentThread().interrupt();
            }
        }

        log.info("All chats have been completed.");
    }
}

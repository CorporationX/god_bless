package school.faang.bjs2_89919;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Slf4j
public class ChatManager {
    private final UserList userList;
    private final List<Chat> activeChats = new ArrayList<>();
    private static final Random random = new Random();
    private final Object monitor = new Object();

    public ChatManager(UserList userList) {
        this.userList = userList;
    }

    private void createChat(User user, User otherUser) {
        Chat chat = new Chat(user, otherUser);
        activeChats.add(chat);
        user.setChat(chat);
        otherUser.setChat(chat);
        log.info("{} начал чат с {}", user.getName(), otherUser.getName());
    }

    public void startChat(User user) {
        User otherUser;
        synchronized (monitor) {
            while (userList.getOnlineUsersLookingForChat(user).isEmpty() || activeChats.contains(user.getChat())) {
                try {
                    monitor.wait();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    log.warn("Поток {} был прерван во время ожидания.", Thread.currentThread().getName());
                    return;
                }
            }
            List<User> candidates = userList.getOnlineUsersLookingForChat(user);
            otherUser = candidates.get(random.nextInt(candidates.size()));

            userList.removeUser(user);
            userList.removeUser(otherUser);
        }

        createChat(user, otherUser);

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            log.warn("Поток {} был прерван во время сна.", Thread.currentThread().getName());
        }

        user.getChat().ifPresent(this::endChat);

    }

    private void waitForChat() {
        synchronized (monitor) {
            try {
                log.info("Поток {} ожидает появления чата...", Thread.currentThread().getName());
                monitor.wait();
                log.info("Поток {} пробужден для проверки состояния чатов.", Thread.currentThread().getName());
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                log.warn("Поток {} был прерван во время ожидания.", Thread.currentThread().getName());
            }
        }
    }

    public void endChat(Chat chat) {
        synchronized (monitor) {
            if (chat == null) {
                return;
            }
            activeChats.remove(chat);
            User user1 = chat.getUser1();
            User user2 = chat.getUser2();
            user1.resetChat();
            user2.resetChat();
            log.info("{} завершил чат {}", user1.getName(), user2.getName());
            monitor.notifyAll();
        }
    }
}
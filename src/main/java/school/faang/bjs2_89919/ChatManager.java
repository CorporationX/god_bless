package school.faang.bjs2_89919;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ChatManager {
    private static final Logger log = LoggerFactory.getLogger(ChatManager.class);
    private final UserList userList;
    private final List<Chat> activeChats = new ArrayList<>();
    private static final Object lock = new Object();
    private static final Random random = new Random();

    public ChatManager(UserList userList) {
        this.userList = userList;
    }

    public synchronized void startChat(User user) {
        while (userList.getOnlineUsersLookingForChat(user).isEmpty() || activeChats.contains(user.getChat())) {
            waitForChat();
        }

        User otherUser = userList.getOnlineUsersLookingForChat(user)
                .get(random.nextInt(0, userList.getOnlineUsersLookingForChat(user).size()));
        Chat chat = new Chat(user, otherUser);
        activeChats.add(chat);
        user.setChat(chat);
        otherUser.setChat(chat);
        log.info("{} начал чат с {}", user.getName(), otherUser.getName());
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        endChat(user);
    }

    public void waitForChat() {
        try {
            log.info("Поток {} ожидает появления чата...", Thread.currentThread().getName());
            lock.wait();
            log.info("Поток {} пробужден для проверки состояния чатов.", Thread.currentThread().getName());
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            log.warn("Поток {} был прерван во время ожидания.", Thread.currentThread().getName());
        }
    }

    public synchronized void endChat(User user) {
        Chat chat = user.getChat();
        activeChats.remove(chat);
        User user1 = chat.user1();
        User user2 = chat.user2();
        user1.resetChat();
        user2.resetChat();
        log.info("{} завершил чат {}", user1.getName(), user2.getName());
        lock.notifyAll();
    }
}
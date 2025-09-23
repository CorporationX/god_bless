package school.faang.bjs2_89937;

import lombok.extern.slf4j.Slf4j;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

@Slf4j
public class ChatManager {
    private final Map<Long, Chat> activeChats = new ConcurrentHashMap<>();
    private final AtomicLong chatIdGenerator = new AtomicLong(1);
    private final UserList userList;

    public ChatManager(UserList userList) {
        this.userList = userList;
    }

    public synchronized Chat startChat(User u1, User u2) {
        if (!u1.isOnline() || !u2.isOnline()) {
            throw new IllegalStateException("Оба пользователя должны быть онлайн");
        }
        Chat chat = new Chat(u1, u2);
        long id = chatIdGenerator.getAndIncrement();
        activeChats.put(id, chat);

        u1.joinChat();
        u2.joinChat();

        log.info("Чат #{} создан: {} ↔ {}", id, u1.getName(), u2.getName());
        notifyAll();
        return chat;
    }

    public synchronized Chat waitForChat(User user) {
        while (findChatByUser(user) == null) {
            try {
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                return null;
            }
        }
        Chat chat = findChatByUser(user);
        log.info("{} получил чат!", user.getName());
        return chat;
    }

    public synchronized void endChat(User user) {
        Chat chat = findChatByUser(user);
        if (chat != null) {
            activeChats.values().remove(chat);
            chat.user1().leaveChat();
            chat.user2().leaveChat();
            log.info("Чат с участием {} завершён", user.getName());
            notifyAll();
        }
    }

    private Chat findChatByUser(User user) {
        return activeChats.values().stream()
                .filter(c -> c.isParticipant(user))
                .findFirst()
                .orElse(null);
    }
}
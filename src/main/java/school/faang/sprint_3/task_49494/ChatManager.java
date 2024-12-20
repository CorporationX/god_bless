package school.faang.sprint_3.task_49494;

import lombok.extern.slf4j.Slf4j;

import java.util.*;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

@Slf4j
public class ChatManager {
    private final ReentrantLock lock = new ReentrantLock();
    private final Condition condition = lock.newCondition();
    private final List<Chat> chats;
    private final Queue<User> waitingUsers;

    public ChatManager() {
        chats = new ArrayList<>();
        waitingUsers = new LinkedList<>();
    }

    public void addChat(int id) {
        Chat chat = new Chat(id);
        chats.add(chat);
    }

    public void startChat(User user) {
        ValidationUtils.isNotNull(user, "Пользователь");
        lock.lock();
        try {
            Optional<Chat> optionalChat = getFreeChat();
            optionalChat.ifPresent(chat -> {
                chat.setUser(user);
                log.info("{} добавлен в чат №{}", user.getName(), chat.getChatId());
            });
            user.setLookingForChat(false);
        } finally {
            lock.unlock();
        }
    }

    public void waitForChat(User user) {
        ValidationUtils.isNotNull(user, "Пользователь");
        lock.lock();
        try {
            if (user.isLookingForChat() && getFreeChat().isPresent()) {
                startChat(user);
            } else {
                try {
                    log.info("Ожидаю освобождение места в чате...");
                    waitingUsers.add(user);
                    condition.await();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    log.error("Поток прерван во время ожидания");
                }
            }
        } finally {
            lock.unlock();
        }
    }

    public void endChat(Chat chat) {
        lock.lock();
        try {
            chat.disconnectUsers();
            log.info("Чат №{} завершен", chat.getChatId());
            while (!waitingUsers.isEmpty() && getFreeChat().isPresent()) {
                startChat(waitingUsers.poll());
            }
            condition.signalAll();
        } finally {
            lock.unlock();
        }
    }

    private Optional<Chat> getFreeChat() {
        return chats.stream()
                .filter(chat -> chat.getUser1() == null || chat.getUser2() == null)
                .findFirst();
    }

    public Chat getChatFromId(int id) {
        return chats.stream()
                .filter(chat -> chat.getChatId() == id)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Пользователь с таким ID не найден"));
    }
}

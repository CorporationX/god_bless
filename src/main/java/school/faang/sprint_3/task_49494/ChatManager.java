package school.faang.sprint_3.task_49494;

import lombok.extern.slf4j.Slf4j;

import java.util.*;

@Slf4j
public class ChatManager {
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

    public synchronized void startChat(User user) {
        ValidationUtils.isNotNull(user, "Пользователь");
        while (getFreeChat().isEmpty()) {
            waitingUsers.add(user);
            waitForChat();
        }
        Optional<Chat> optionalChat = getFreeChat();
        optionalChat.ifPresent(chat -> {
            chat.setUser(user);
            log.info("{} добавлен в чат №{}", user.getName(), chat.getChatId());
        });
        user.setLookingForChat(false);
    }

    private synchronized void waitForChat() {
        try {
            log.info("Ожидаю освобождение места в чате...");
            wait();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            log.error("Поток прерван во время ожидания");
        }
    }

    public synchronized void endChat(Chat chat) {
        chat.disconnectUsers();
        log.info("Чат №{} завершен", chat.getChatId());
        if (!waitingUsers.isEmpty()) {
            startChat(waitingUsers.poll());
        }
        notifyAll();
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

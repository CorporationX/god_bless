package school.faang.tinder;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Slf4j
@AllArgsConstructor
public class ChatManager {

    private static final int MIN_USERS_FOR_CHAT = 2;

    private final UserList userList;

    public synchronized Chat startChat(User user) {
        List<User> availableUsers = userList.getOnlineUsers();
        while (availableUsers.isEmpty() || availableUsers.size() < MIN_USERS_FOR_CHAT) {
            log.warn("Список пользователей, готовых к общению, пуст");
            waitForChat();
            availableUsers = userList.getOnlineUsers();
        }
        User companion = availableUsers
                .stream()
                .filter(person -> !person.equals(user))
                .findFirst()
                .orElse(null);
        userList.removeUser(user);
        userList.removeUser(companion);
        if (companion == null) {
            log.warn("Произошла ошибка в поиске собеседника! Запускаю процесс заново!");
            waitForChat();
            return startChat(user);
        }
        log.info("Создан чат между {} и {}", user.getName(), companion.getName());
        return new Chat(user, companion);
    }

    public synchronized void endChat(Chat chat) {
        if (!chat.isActive()) {
            log.warn("Чат уже завершен");
            return;
        }
        userList.addUser(chat.getFirstUser());
        userList.addUser(chat.getSecondUser());
        chat.blockChat();
        log.info("Пользователи покинули чат и готовы для дальнейшего общения");
        notifyAll();
    }

    private void waitForChat() {
        try {
            log.info("Поток ожидает свободных пользователей");
            wait();
        } catch (InterruptedException e) {
            log.error("Поток прерван во время ожидания появления свободных пользователей, ", e);
            Thread.currentThread().interrupt();
            throw new RuntimeException(e);
        }
    }
}

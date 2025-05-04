package school.faang.stream3.mattersoftheheart;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

@AllArgsConstructor
@Slf4j
public class ChatManager {
    private Integer startChatLock = 0;
    private Integer waitForChatLock = 0;
    private UserList users;

    /**
     * начинает чат для данного пользователя.
     * Если нет доступных собеседников, метод должен ждать,
     * пока кто-то не присоединится.
     */
    public Chat startChat(User user) {
        synchronized (startChatLock) {
            List<User> onlineUsersForChat = users.getOnlineUsers().stream()
                    .filter(User::isLookingForChat)
                    .toList();
            if (onlineUsersForChat.isEmpty()) {
                try {
                    startChatLock.wait();
                } catch (InterruptedException e) {
                    log.error("Interrupted during startChat waiting {}", e.getMessage());
                }
            }
            onlineUsersForChat.remove(user);
            return new Chat(user, onlineUsersForChat.get(0));
        }
    }

    /**
     * проверяет, есть ли доступный чат для пользователя.
     * Если нет, ожидает, пока чат не будет создан.
     */
    public Chat waitForChat(User user) {
        return null;
    }

    /**
     * завершает чат и уведомляет потоки,
     * которые ждут начала нового чата.
     */
    public void endChat(Chat chat) {

    }
}
